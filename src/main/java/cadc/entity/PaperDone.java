package cadc.entity;

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
@TableName("paper_done")
public class PaperDone extends Model<PaperDone> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private int userId;
    private Double sumScore;
    private Date costTime;
    private int paperId;
}
