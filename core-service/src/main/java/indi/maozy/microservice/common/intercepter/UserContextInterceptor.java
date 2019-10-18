package indi.maozy.microservice.common.intercepter;

import indi.maozy.microservice.common.exception.PermissionException;
import indi.maozy.microservice.common.util.UserPermissionUtil;
import indi.maozy.microservice.common.vo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 * 用户上下文拦截器
 *
 * @author 毛中勇
 * @create 2019-10-16 10:50
 */
public class UserContextInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = getUser(request);
        UserPermissionUtil.permission(user);
        if (!UserPermissionUtil.verify(user, request)) {
            response.setHeader("Content-Type", "application/json");
            String jsonStr = "no permission access service,please check";
            response.getWriter().write(jsonStr);
            response.getWriter().flush();
            response.getWriter().close();
            throw new PermissionException("no permission access service,please check");
        }

        UserContextHolder.set(user);
        return true;
    }

    private User getUser(HttpServletRequest request) {

        String userId = request.getHeader("x-user-id");

        String username = request.getHeader("x-user-name");

        User user = new User();
        user.setUserId(userId);
        user.setUserName(username);
        return user;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextHolder.shutdown();
    }

}