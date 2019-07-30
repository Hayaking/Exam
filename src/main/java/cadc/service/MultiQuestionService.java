package cadc.service;

import cadc.entity.MultiQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface MultiQuestionService extends IService<MultiQuestion> {

    List<MultiQuestion> getRandom(int size);
}
