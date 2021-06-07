package com.tansun.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    // 私有化构造函数，让工具类不能创建实例对象
    private CookieUtil(){}

    /**
     * 添加cookie
     * @param httpServletResponse
     * @param cookieName
     * @param value
     * @param domian
     * @param path
     * @param maxAge
     */
    public static void setCookie(HttpServletResponse httpServletResponse, String cookieName,
                                 String value, String domian, String path, int maxAge){
        Cookie cookie = new Cookie(cookieName, value);
        if (null != domian){
            cookie.setDomain(domian);
        }
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        // 将cookie返回
        httpServletResponse.addCookie(cookie);

    }

    /**
     * 获取cookie
     * @param httpServletRequest
     * @param name
     * @return
     */
    public static String getCookie(HttpServletRequest httpServletRequest, String name){
        String value = null;
        Cookie[] cookies = httpServletRequest.getCookies();
        if (null != cookies){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 判断是否有这个cookie
                if (cookie.getName().equals(name)){
                    value = cookie.getValue();
                }
            }
        }
        return value;
    }

    /**
     * 删除cookie 将该cookie的value置为空，有效时间置为0
     * @param httpServletResponse
     * @param name
     * @param domain
     * @param path
     */
    public static void removeCookie(HttpServletResponse httpServletResponse, String name, String domain, String path){
        setCookie(httpServletResponse,name,null, domain, path, 0);

    }

}
