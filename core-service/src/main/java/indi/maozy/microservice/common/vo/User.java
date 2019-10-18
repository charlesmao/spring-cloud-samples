package indi.maozy.microservice.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 描述:
 * 用户信息
 *
 * @author 毛中勇
 * @create 2019-10-16 11:06
 */
public class User implements Serializable {

    public static final String CONTEXT_KEY_USERID = "x-user-id";

    private String userId;
    private String userName;

    private List<String> allowPermissionService;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getAllowPermissionService() {
        return allowPermissionService;
    }

    public void setAllowPermissionService(List<String> allowPermissionService) {
        this.allowPermissionService = allowPermissionService;
    }
}