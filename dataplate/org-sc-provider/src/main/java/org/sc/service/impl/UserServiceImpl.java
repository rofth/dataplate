package org.sc.service.impl;

import org.sc.bean.User;
import org.sc.mapper.dao.UserDao;
import org.sc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 业务层
 */
@Service
public class UserServiceImpl implements UserService {


    @Resource(name = "userDao")
    private UserDao userDao;


    @Override
    public List<Map> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserInfo(Integer id) {
        return userDao.getUserInfo(id);
    }
}
