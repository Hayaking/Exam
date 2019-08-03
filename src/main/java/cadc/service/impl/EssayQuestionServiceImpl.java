package cadc.service.impl;

import cadc.entity.EssayQuestion;
import cadc.mapper.EssayQuestionMapper;
import cadc.service.EssayQuestionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EssayQuestionServiceImpl extends ServiceImpl<EssayQuestionMapper, EssayQuestion> implements EssayQuestionService {
    @Resource
    private EssayQuestionMapper essayQuestionMapper;

    @Override
    public List<EssayQuestion> getRandom(int size) {
        return null;
    }

    @Override
    public IPage<EssayQuestion> getAll(Page<EssayQuestion> page) {
        return essayQuestionMapper.selectPage( page, new QueryWrapper<>() );
    }
}
