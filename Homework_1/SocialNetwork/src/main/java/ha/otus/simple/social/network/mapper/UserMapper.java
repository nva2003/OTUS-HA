package ha.otus.simple.social.network.mapper;

import ha.otus.simple.social.network.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    public SysUser findByUserName(String username);

    public SysUser findById(Long id);
    @Deprecated
    public List<SysUser> findAll();

    public List<SysUser> findOther(Long id);

    void createUser(SysUser userDTO);

    @Deprecated
    void updatePassword(String password, Long id);
    @Deprecated
    void updateUser(SysUser userDTO);
}
