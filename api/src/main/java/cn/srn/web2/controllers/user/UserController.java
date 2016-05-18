package cn.srn.web2.controllers.user;

import cn.srn.web2.errorinfo.ErrorInfo;
import cn.srn.web2.repositories.entity.entities.user.User;
import cn.srn.web2.response.user.UserInfo;
import cn.srn.web2.services.user.UserService;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import cn.srn.web2.WebConst;
import cn.srn.web2.repositories.entity.search.user.UserLoginCondition;
import cn.srn.web2.response.ResponseInfo;
import cn.srn.web2.response.user.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Winter on 2016/5/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private static JWTSigner signer = new JWTSigner("my secret");
    private static JWTVerifier verifier = new JWTVerifier("my secret");
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseInfo userInfo(@RequestParam("token") String token) {
        try {
            Map<String, Object> claims = verifier.verify(token);
            //String mobile = (String) claims.get(WebConst.TOKEN_MOBILE);
            long userId = (Integer) claims.get(WebConst.TOKEN_USERID);
            //String username = (String) claims.get(WebConst.TOKEN_USERNAME);
            User user = userService.findOne(userId);
            return new UserInfo(ErrorInfo.SUCCESS, user.getId(), user.getRealname());
        } catch (Exception e) {
            logger.error("userInfo", e );
            return new ResponseInfo(ErrorInfo.LOGOUT_NOLOGIN);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseInfo login(UserLoginCondition condition) {
        User user = userService.findUserByMobileAndPassword(condition);
        if (user != null) {
            JWTSigner.Options options = new JWTSigner.Options();
            //options.setJwtId(true);
            options.setExpirySeconds(7200);
            Map<String, Object> claims = new HashMap<>();
            //claims.put(WebConst.TOKEN_TIME, );
            //claims.put(WebConst.TOKEN_MOBILE, user.getMobile());
            claims.put(WebConst.TOKEN_USERID, user.getId());
            //claims.put(WebConst.TOKEN_USERNAME, user.getRealname());
            String token = signer.sign(claims, options);
            return new TokenResponse(ErrorInfo.SUCCESS, token);
        } else {
            return new ResponseInfo(ErrorInfo.LOGIN_FAIL);
        }
    }
}
