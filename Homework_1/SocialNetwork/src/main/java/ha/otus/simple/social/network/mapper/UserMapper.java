package ha.otus.simple.social.network.mapper;

import ha.otus.simple.social.network.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public SysUser findByUserName(String username);

    void createUser(SysUser userDTO);

    void updatePassword(String password, Long id);

    void updateUser(SysUser userDTO);
}
