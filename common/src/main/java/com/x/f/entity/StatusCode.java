package com.x.f.entity;

/**
 * 状态码实体类
 *
 * @author zoe
 * @date 2019-01-03
 */
public class StatusCode {

    public static final int OK=2000;//成功
    public static final int ERROR=2001;//失败
    public static final int LOGINERROR=2002;//用户名或密码错误
    public static final int ACCESSRROR=2003;//权限不足
    public static final int REEMOTERROR=2004;//远程调用失败
    public static final int REPERROR=2005;//重复操作

}
