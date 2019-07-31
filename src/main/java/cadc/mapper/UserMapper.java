package cadc.mapper;

import cadc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author haya
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Delete( "delete from user where account = #{account}" )
    int deleteByAccount(String account);

    /**
     * 获取所有学生
     * @return
     */
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "clazz", property = "clazz"),
            @Result(column = "school_id", property = "schoolName", one = @One(select = "cadc.mapper.SchoolMapper.getSchoolNameById")),
    })
    @Select( "select * FROM user JOIN user_role ON USER.id = user_role.user_id JOIN role ON role.id = user_role.role_id where role.role_name='考生'" )
    List<User> getAllStudent();

}
