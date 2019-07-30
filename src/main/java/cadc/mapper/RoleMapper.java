package cadc.mapper;

import cadc.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author haya
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    @Select( "select role.id,role.role_name from role JOIN user_role ON role.id = user_role.role_id JOIN user ON user_role.user_id = user.id  where user.account= #{account}" )
    List<Role> getRoleList(String account);
}
