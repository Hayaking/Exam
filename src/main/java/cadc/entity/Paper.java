package cadc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author haya
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("paper")
public class Paper extends Model<Paper> implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private int id;
    private String paperCreator;
    private String paperCreateTime;
    private int examId;

    public Paper() {
    }

    public Paper(String paperCreator, String paperCreateTime, int examId) {
        this.paperCreator = paperCreator;
        this.paperCreateTime = paperCreateTime;
        this.examId = examId;
    }
}
