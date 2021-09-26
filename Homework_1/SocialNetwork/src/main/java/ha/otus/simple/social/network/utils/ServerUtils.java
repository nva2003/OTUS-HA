package ha.otus.simple.social.network.utils;

import ha.otus.simple.social.network.mapper.UserMapper;
import ha.otus.simple.social.network.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ServerUtils {
    @Autowired
    UserMapper userMapper;


    public SysUser getUserFromSession(HttpServletRequest request){
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = userMapper.findByUserName(authentication.getName());
            request.getSession().setAttribute("user", user);
        }
        return  user;
    }

}
