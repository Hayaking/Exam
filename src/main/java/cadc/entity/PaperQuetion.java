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
@TableName("paper_question")
public class PaperQuetion extends Model<PaperQuetion> implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableId
    private int id;
    private int paperId;
    private int questionId;
    private String questionType;

    public PaperQuetion() {
    }

    public PaperQuetion(int paperId, int questionId, String questionType) {
        this.paperId = paperId;
        this.questionId = questionId;
        this.questionType = questionType;
    }
}
