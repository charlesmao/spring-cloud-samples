package indi.maozy.microservice.common.intercepter;

import indi.maozy.microservice.common.vo.User;

/**
 * 描述:
 * 用户上下文
 *
 * @author 毛中勇
 * @create 2019-10-17 15:33
 */
public class UserContextHolder {

    public static ThreadLocal<User> context = new ThreadLocal<>();

    public static User currentUser() {
        return context.get();
    }

    public static void set(User user) {
        context.set(user);
    }

    public static void shutdown() {
        context.remove();
    }


}