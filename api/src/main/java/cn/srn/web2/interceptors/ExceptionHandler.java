package cn.srn.web2.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Winter on 2016/4/29.
 */
public class ExceptionHandler implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        Map<String, Object> model = new HashMap<>();
//        model.put("ex", ex);

        // 根据不同错误转向不同页面
//        if(ex instanceof Exception) {
//            return new ModelAndView("404", model);
//        }
        logger.error("请求(" + request.getRequestURI() + ")发生异常: ", ex);
        return new ModelAndView("404");

    }
}
