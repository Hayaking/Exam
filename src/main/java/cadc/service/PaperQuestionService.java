package cadc.service;

import cadc.entity.PaperQuetion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * @author haya
 */
public interface PaperQuestionService extends IService<PaperQuetion> {
    boolean insertList(HashMap<String, Object> map);
}
