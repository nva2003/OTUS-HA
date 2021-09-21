package ha.otus.simple.social.network.controller;

import ha.otus.simple.social.network.mapper.UserMapper;
import ha.otus.simple.social.network.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response, Model model) {

        model.addAttribute("user", new SysUser());

        return "/register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user")SysUser userDTO, BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        SysUser userByUserName = userMapper.findByUserName(userDTO.getUserName());
        if (userByUserName != null) {
            model.addAttribute("registrationError", true);
            model.addAttribute("user", userDTO);
            return "register";
        }
        userMapper.createUser(userDTO);
        return "about";
    }


}

