package cadc.mapper;

import cadc.entity.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author haya
 */
public interface ExamMapper extends BaseMapper<Exam> {
    @Update("update exam set paper_state = #{state} where id = #{id}")
    int updatePaperState(@Param( "id" ) int id, @Param("state") String state);
}
