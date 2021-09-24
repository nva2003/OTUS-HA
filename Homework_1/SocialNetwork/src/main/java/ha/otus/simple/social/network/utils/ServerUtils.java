package ha.otus.simple.social.network.utils;

import ha.otus.simple.social.network.model.SysUser;

import javax.servlet.http.HttpServletRequest;


public class ServerUtils {

    public static SysUser getUserFromSession(HttpServletRequest request){
        return (SysUser) request.getSession().getAttribute("user");
    }

}
