package cn.srn.web2.repositories.daos.user;

import cn.srn.web2.repositories.daos.BaseDao;
import cn.srn.web2.repositories.entity.entities.user.User;
import cn.srn.web2.repositories.entity.search.Condition;
import org.springframework.stereotype.Repository;

/**
 * Created by Winter on 2016/5/17.
 */
@Repository
public interface UserDao extends BaseDao<User, Long> {

    User findByMobileAndPassword(Condition condition);

}
