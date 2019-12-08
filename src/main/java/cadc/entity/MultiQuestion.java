package cadc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("multi_question")
public class MultiQuestion extends Model<MultiQuestion> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private int id;
    private String subject;
    private String answer;
    private String chioceA;
    private String chioceB;
    private String chioceC;
    private String chioceD;
    private String chioceE;
    private String chioceF;
    private Double score;
    private int level;
}
