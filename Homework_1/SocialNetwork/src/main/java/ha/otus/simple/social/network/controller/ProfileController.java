package ha.otus.simple.social.network.controller;

import ha.otus.simple.social.network.mapper.FriendsMapper;
import ha.otus.simple.social.network.mapper.UserMapper;
import ha.otus.simple.social.network.model.Friendship;
import ha.otus.simple.social.network.model.SysUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

import static ha.otus.simple.social.network.utils.ServerUtils.getUserFromSession;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ProfileController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    private final FriendsMapper friendsMapper;

    @GetMapping("/profile")
    public String getProfilePage(Model model, HttpServletRequest request) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        SysUser user = userMapper.findByUserName(authentication.getName());
        SysUser user = getUserFromSession(request);
        model.addAttribute("user", user);
        Set<SysUser> friends = friendsMapper.getAcceptedFriendshipUsers(user.getUserId());
        model.addAttribute("friends", friends);
        return "profile";
    }

    @GetMapping("/profile/{id}")
    public String getUserPage(@PathVariable Long id, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        SysUser sessionUser = getUserFromSession(request);
        if(sessionUser.getUserId().equals(id)) {
            return "redirect:/user/profile";
        }
        SysUser user = userMapper.findById(id);
        Set<SysUser> friends = friendsMapper.getAcceptedFriendshipUsers(id);
        Friendship friendship = new Friendship (id,sessionUser.getUserId());
        Boolean isFriend = friendsMapper.checkFriendship(friendship);
        model.addAttribute("user", user);
        model.addAttribute("usersHaveFriendship", isFriend);
        model.addAttribute("friends", friends);
        return "profile";
    }

}
