package cadc.mapper;

import cadc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author haya
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
