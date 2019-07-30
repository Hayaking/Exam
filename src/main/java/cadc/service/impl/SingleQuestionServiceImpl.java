package cadc.service.impl;

import cadc.entity.SingleQuestion;
import cadc.mapper.SingleQuestionMapper;
import cadc.service.SingleQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SingleQuestionServiceImpl extends ServiceImpl<SingleQuestionMapper, SingleQuestion> implements SingleQuestionService {
    @Override
    public List<SingleQuestion> getRandom(int size) {
        return null;
    }
}
