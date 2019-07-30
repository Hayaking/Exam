package cadc.mapper;

import cadc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author haya
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Delete( "delete from user where account = #{account}" )
    int deleteByAccount(String account);
}
