package cadc.service.impl;

import cadc.entity.MultiQuestion;
import cadc.mapper.MultiQuestionMapper;
import cadc.service.MultiQuestionService;
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
public class MultiQuestionServiceImpl extends ServiceImpl<MultiQuestionMapper, MultiQuestion> implements MultiQuestionService {
    @Resource
    private MultiQuestionMapper multiQuestionMapper;

    @Override
    public List<MultiQuestion> getRandom(int size) {
        return null;
    }

    @Override
    public IPage<MultiQuestion> getAll(Page<MultiQuestion> page) {
        return multiQuestionMapper.selectPage( page, new QueryWrapper<>() );
    }
}
