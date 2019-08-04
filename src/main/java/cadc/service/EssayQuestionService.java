package cadc.service;

import cadc.entity.EssayQuestion;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface EssayQuestionService extends IService<EssayQuestion> {

    List<EssayQuestion> getRandom(int size);

    IPage<EssayQuestion> getAll(Page<EssayQuestion> page);
}
