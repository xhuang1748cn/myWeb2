package cn.srn.web2.services.user;

import cn.srn.web2.repositories.entity.entities.user.User;
import cn.srn.web2.repositories.entity.search.Condition;
import cn.srn.web2.repositories.daos.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Winter on 2016/5/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByMobileAndPassword(Condition condition) {
        return userDao.findByMobileAndPassword(condition);
    }

    @Override
    public User findOne(long userId) {
        return userDao.findOne(userId);
    }
}
