package org.sc.mapper.dao;

import org.sc.bean.User;

import java.util.List;
import java.util.Map;

/**
 * 用户接口
 */
public interface UserDao {

    //@Select("select * FROM users_usercenter")
    List<Map> getUserList();

    //@Select("select * from users_usercenter where id = #{id}")
    User getUserInfo(Integer id);
}
