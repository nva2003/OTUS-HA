package ha.otus.simple.social.network.controller;

import ha.otus.simple.social.network.mapper.UserMapper;
import ha.otus.simple.social.network.model.SysUser;
import ha.otus.simple.social.network.utils.ServerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * Created by Dmitrii on 03.10.2019.
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    ServerUtils serverUtils;
    @Value("${default.page.size}")
    private Integer defaultPageSize;

    private static final String VIEWS_FIND_USER_FORM = "findUsers";
    private static final String VIEWS_USER_LIST_FORM = "users";

    private final UserMapper userMapper;

    @GetMapping("/users")
    public String getUserList(HttpServletRequest request,
                              Model model) {
        SysUser user = serverUtils.getUserFromSession(request);
        List<SysUser> users = userMapper.findOther(user.getUserId());
            model.addAttribute("users",users);
        return VIEWS_USER_LIST_FORM;
    }

    @GetMapping("/find")
    public String findUsers(Map<String, Object> model) {
        model.put("user", new SysUser());
        model.put("menu", "find users");
        return VIEWS_FIND_USER_FORM;
    }

    @PostMapping("/find")
    public String processFindForm(@ModelAttribute("user") SysUser user, BindingResult result, Map<String, Object> model) throws UnsupportedEncodingException {

        // find users by last name
        //todo
        List<SysUser> users = userMapper.find(user);
        if (users.isEmpty()) {
            // no users found
            model.put("msg", "Пользователь с заданами параметрами не найден");
//            model.put("menu", "find users");
            return VIEWS_FIND_USER_FORM;

        } else {
            // multiple users found
            model.put("users",users);
//            model.put("menu", "user list");


            return VIEWS_USER_LIST_FORM;
        }
    }
}
