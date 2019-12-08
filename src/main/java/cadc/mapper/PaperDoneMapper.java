package cadc.mapper;

import cadc.entity.PaperDone;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author haya
 */
public interface PaperDoneMapper extends BaseMapper<PaperDone> {
    @Update( "update paper_done set sum_score = #{score} where id =#{id}" )
    int updateSumScore(int id, double score);


}
