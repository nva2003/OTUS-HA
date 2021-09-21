package ha.otus.simple.social.network.mapper;

import ha.otus.simple.social.network.model.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface PermissionMapper {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId);
}
