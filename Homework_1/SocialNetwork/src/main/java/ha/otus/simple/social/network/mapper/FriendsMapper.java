package ha.otus.simple.social.network.mapper;

import ha.otus.simple.social.network.model.Friendship;
import ha.otus.simple.social.network.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface FriendsMapper {

    List<SysUser> getFriends(Long userId);

    Set<SysUser> getAcceptedFriendshipUsers(Long id);

    void deleteFriendship(SysUser userDTO, Long friendId);

    @Deprecated
    void acceptFriendship(Long userId, Long friendId);

    void addToFriends(Long userId, Long friendId);

    Boolean checkFriendship(Friendship friendship);
}
