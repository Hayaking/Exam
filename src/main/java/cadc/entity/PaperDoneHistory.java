package cadc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author haya
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("paper_done_history")
public class PaperDoneHistory extends Model<PaperDoneHistory> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private int id;
    private String userAnswer;
    private int questionId;
    private String questionType;
    private int paperDoneId;
}
