package cadc.service.impl;

import cadc.entity.JudgeQuestion;
import cadc.mapper.JudgeQuestionMapper;
import cadc.service.JudgeQuestionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class JudgeQuestionServiceImpl extends ServiceImpl<JudgeQuestionMapper, JudgeQuestion> implements JudgeQuestionService {
    @Resource
    private JudgeQuestionMapper judgeQuestionMapper;

    @Override
    public List<JudgeQuestion> getRandom(int size) {
        return null;
    }

    @Override
    public IPage<JudgeQuestion> getAll(Page<JudgeQuestion> page) {
        return judgeQuestionMapper.selectPage( page, new QueryWrapper<>() );
    }
}
