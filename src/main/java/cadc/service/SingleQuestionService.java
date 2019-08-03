package cadc.service;

import cadc.entity.SingleQuestion;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface SingleQuestionService extends IService<SingleQuestion> {
    List<SingleQuestion> getRandom(int size);

    IPage<SingleQuestion> getAll(Page<SingleQuestion> page);

}

