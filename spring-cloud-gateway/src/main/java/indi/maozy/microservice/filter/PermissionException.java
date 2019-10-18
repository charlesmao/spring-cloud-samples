package indi.maozy.microservice.filter;

/**
 * 描述:
 *
 * @author 毛中勇
 * @create 2019-10-17 16:31
 */
public class PermissionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PermissionException(String msg) {
        super(msg);
    }

}