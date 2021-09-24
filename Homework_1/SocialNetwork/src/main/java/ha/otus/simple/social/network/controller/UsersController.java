package ha.otus.simple.social.network.controller;

import ha.otus.simple.social.network.mapper.UserMapper;
import ha.otus.simple.social.network.model.SysUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ha.otus.simple.social.network.utils.ServerUtils.getUserFromSession;


/**
 * Created by Dmitrii on 03.10.2019.
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {

    @Value("${default.page.size}")
    private Integer defaultPageSize;

    private final UserMapper userMapper;

    @GetMapping("/users")
    public String getUserList(HttpServletRequest request,
                              Model model) {
        SysUser user = getUserFromSession(request);
        List<SysUser> users = userMapper.findOther(user.getUserId());
            model.addAttribute("users",users);
        return "users";
    }
}
