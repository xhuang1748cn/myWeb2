package cn.srn.web2.repositories.daos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Winter on 2016/5/18.
 */
public interface BaseDao<T, KEY extends Serializable> {

    long addEntity(T t);

    long addEntities(T ... t);

    T findOne(KEY id);

    List<T> findList(KEY ... id);

    long deleteEntities(KEY ... ids);

}
