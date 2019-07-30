package cadc.service.impl;

import cadc.entity.MultiQuestion;
import cadc.mapper.MultiQuestionMapper;
import cadc.service.MultiQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MultiQuestionServiceImpl extends ServiceImpl<MultiQuestionMapper, MultiQuestion> implements MultiQuestionService {

    @Override
    public List<MultiQuestion> getRandom(int size) {
        return null;
    }
}
