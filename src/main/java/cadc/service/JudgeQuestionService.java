package cadc.service;

import cadc.entity.JudgeQuestion;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface JudgeQuestionService extends IService<JudgeQuestion> {
    List<JudgeQuestion> getRandom(int size);

    IPage<JudgeQuestion> getAll(Page<JudgeQuestion> page);
}
