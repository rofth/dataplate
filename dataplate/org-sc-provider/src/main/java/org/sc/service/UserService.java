package org.sc.service;

import org.sc.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map> getUserList();

    User getUserInfo(Integer id);
}
