package cadc.service.impl;

import cadc.entity.JudgeQuestion;
import cadc.mapper.JudgeQuestionMapper;
import cadc.service.JudgeQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JudgeQuestionServiceImpl extends ServiceImpl<JudgeQuestionMapper, JudgeQuestion> implements JudgeQuestionService {

    @Override
    public List<JudgeQuestion> getRandom(int size) {
        return null;
    }
}
