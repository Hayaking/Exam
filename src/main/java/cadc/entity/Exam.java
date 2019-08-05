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
@TableName("exam")
public class Exam extends Model<Exam> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private int id;
    private String examName;
    private Date examStartTime;
    private int examCreator;
    private int schoolId;
    private String examState;
    private String paperState;
}
