package cn.srn.web2.services.user;

import cn.srn.web2.repositories.entity.entities.user.User;
import cn.srn.web2.repositories.entity.search.Condition;

/**
 * Created by Winter on 2016/5/17.
 */
public interface UserService {

    User findUserByMobileAndPassword(Condition condition);

    User findOne(long userId);
}
