package ha.otus.simple.social.network.controller;

import ha.otus.simple.social.network.mapper.FriendsMapper;
import ha.otus.simple.social.network.model.Friendship;
import ha.otus.simple.social.network.model.SysUser;
import ha.otus.simple.social.network.utils.ServerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/user/friends")
@RequiredArgsConstructor
public class FriendsController {

    @Autowired
    ServerUtils serverUtils;

    private final FriendsMapper friendsMapper;

    @GetMapping
    public String getAllFriends(@RequestParam(value = "search", required = false) String search,
            Model model, HttpServletRequest request) {
        SysUser user = serverUtils.getUserFromSession(request);
        List<SysUser> friends = friendsMapper.getFriends(user.getUserId());
        model.addAttribute("friendsOfUser", friends);
        return "friends";
    }

    @GetMapping("/{friendId}/decline")
    public String deleteFriendship(@PathVariable Long friendId, HttpServletRequest request) {
        SysUser user = serverUtils.getUserFromSession(request);
        Friendship friendship = new Friendship(user.getUserId(), friendId);
        friendsMapper.deleteFriendship(friendship);
        return "redirect:/user/friends";
    }

    @Deprecated
    @GetMapping("/{friendId}/accept")
    public String acceptFriendship(@PathVariable Long friendId, HttpServletRequest request) {
        SysUser user = serverUtils.getUserFromSession(request);
        Friendship friendship = new Friendship(user.getUserId(), friendId);
        friendsMapper.acceptFriendship(friendship);
        return "redirect:/user/friends";
    }

    @GetMapping("/{friendId}/addToFriends")
    public String addToFriends(@PathVariable Long friendId, HttpServletRequest request) {
        SysUser user = serverUtils.getUserFromSession(request);
        Friendship friendship = new Friendship(user.getUserId(), friendId);
        friendsMapper.addToFriends(friendship);
        return "redirect:/user/friends";
    }

}
