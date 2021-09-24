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

    void deleteFriendship(Friendship friendship);

    @Deprecated
    void acceptFriendship(Friendship friendship);

    void addToFriends(Friendship friendship);

    Boolean checkFriendship(Friendship friendship);
}
