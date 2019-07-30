package cadc.service.impl;

import cadc.entity.EssayQuestion;
import cadc.mapper.EssayQuestionMapper;
import cadc.service.EssayQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EssayQuestionServiceImpl extends ServiceImpl<EssayQuestionMapper, EssayQuestion> implements EssayQuestionService {

    @Override
    public List<EssayQuestion> getRandom(int size) {
        return null;
    }
}
