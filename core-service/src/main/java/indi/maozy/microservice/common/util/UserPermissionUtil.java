package indi.maozy.microservice.common.util;

import indi.maozy.microservice.common.vo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 用户权限工具类
 *
 * @author 毛中勇
 * @create 2019-10-16 11:14
 */
public class UserPermissionUtil {

    public static boolean verify(User user, HttpServletRequest request) {
        String url = request.getHeader("x-user-serviceName");
        if (user == null) {
            return false;
        } else {
            List<String> list = user.getAllowPermissionService();
            for (String permissionService : list) {
                if (url.equalsIgnoreCase(permissionService)) {
                    return true;
                }
            }
            return false;
        }
    }


    public static void permission(User user) {
        if (user.getUserName().equals("admin")) {
            List<String> allowPermissionService = new ArrayList<>();
            allowPermissionService.add("client-service");
            allowPermissionService.add("provider-service");
            user.setAllowPermissionService(allowPermissionService);
        } else if (user.getUserName().equals("spring")) {
            List<String> allowPermissionService = new ArrayList<>();
            allowPermissionService.add("client-service");
            user.setAllowPermissionService(allowPermissionService);
        } else {
            List<String> allowPermissionService = new ArrayList<>();
            user.setAllowPermissionService(allowPermissionService);
        }
    }

}