package ha.otus.simple.social.network.mapper;

import ha.otus.simple.social.network.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.Set;

@Mapper
public interface FriendsMapper {

    Map<String, Set<SysUser>> getFriends(Long userId, String search);

    Set<SysUser> getAcceptedFriendshipUsers(Long id);

    void deleteFriendship(SysUser userDTO, Long friendId);

    void acceptFriendship(SysUser userDTO, Long friendId);

    void addToFriends(SysUser user, Long friendId);

    Boolean checkFriendship(SysUser user, SysUser friend);
}
