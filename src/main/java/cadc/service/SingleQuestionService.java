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
    boolean add(SingleQuestion singleQuestion);
    boolean deleteById(int id);
    SingleQuestion getById(int id);


    IPage<SingleQuestion> getAll(Page<SingleQuestion> page);

}

