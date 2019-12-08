package cadc.service;

import cadc.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * @author haya
 */
public interface PaperQuestionService extends IService<PaperQuetion> {
    boolean insertList(HashMap<String, Object> map);

    List<SingleQuestion> getSingleByPaperId(int examId);
    List<MultiQuestion> getMultiByPaperId(int examId);
    List<JudgeQuestion> getJudgeByPaperId(int examId);
    List<EssayQuestion> getEssayByPaperId(int examId);
}
