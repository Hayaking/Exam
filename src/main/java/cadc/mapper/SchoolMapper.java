package cadc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SchoolMapper {
    @Select("select * from school where id= #{id}")
    String getSchoolNameById(int id);

}
