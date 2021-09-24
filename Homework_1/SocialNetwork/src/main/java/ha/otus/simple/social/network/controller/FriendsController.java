package ha.otus.simple.social.network.controller;

import ha.otus.simple.social.network.mapper.FriendsMapper;
import ha.otus.simple.social.network.model.SysUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static ha.otus.simple.social.network.utils.ServerUtils.getUserFromSession;

@Controller
@RequestMapping("/user/friends")
@RequiredArgsConstructor
public class FriendsController {

    private final FriendsMapper friendsMapper;

    @GetMapping
    public String getAllFriends(@RequestParam(value = "search", required = false) String search,
            Model model, HttpServletRequest request) {
        SysUser user = getUserFromSession(request);
        List<SysUser> friends = friendsMapper.getFriends(user.getUserId());
        model.addAttribute("friendsOfUser", friends);
        return "friends";
    }

    @GetMapping("/{friendId}/decline")
    public String deleteFriendship(@PathVariable Long friendId, HttpServletRequest request) {
        SysUser user = getUserFromSession(request);
        friendsMapper.deleteFriendship(user, friendId);
        return "redirect:/user/friends";
    }

    @Deprecated
    @GetMapping("/{friendId}/accept")
    public String acceptFriendship(@PathVariable Long friendId, HttpServletRequest request) {
        SysUser user = getUserFromSession(request);
        friendsMapper.acceptFriendship(user.getUserId(), friendId);
        return "redirect:/user/friends";
    }

    @GetMapping("/{friendId}/addToFriends")
    public String addToFriends(@PathVariable Long friendId, HttpServletRequest request) {
        SysUser user = getUserFromSession(request);
        friendsMapper.addToFriends(user.getUserId(), friendId);
        return "redirect:/user/friends";
    }

}
