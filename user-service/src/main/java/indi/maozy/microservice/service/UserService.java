package indi.maozy.microservice.service;

import indi.maozy.microservice.entity.User;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @Author 毛中勇
 * @Date 2019-06-27 19:03
 */
public interface UserService {

    User create(String username, String password);
}
