package indi.maozy.microservice.common.exception;

/**
 * 描述:
 * 权限异常类
 *
 * @author 毛中勇
 * @create 2019-10-16 11:13
 */
public class PermissionException extends RuntimeException {

    public PermissionException(String msg) {
        super(msg);
    }

}