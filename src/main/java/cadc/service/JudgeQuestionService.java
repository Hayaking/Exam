package cadc.service;

import cadc.entity.JudgeQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface JudgeQuestionService extends IService<JudgeQuestion> {
    List<JudgeQuestion> getRandom(int size);

}
