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
@TableName("judge_question")
public class JudgeQuestion extends Model<JudgeQuestion> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private int id;
    private String subject;
    private String answer;
    private Double score;
    private int level;
}
