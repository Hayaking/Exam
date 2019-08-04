package cadc.service.impl;

import cadc.entity.JudgeQuestion;
import cadc.entity.SingleQuestion;
import cadc.mapper.SingleQuestionMapper;
import cadc.service.SingleQuestionService;
import cadc.util.Utils;
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
public class SingleQuestionServiceImpl extends ServiceImpl<SingleQuestionMapper, SingleQuestion> implements SingleQuestionService {
    @Resource
    private SingleQuestionMapper singleQuestionMapper;

    @Override
    public List<SingleQuestion> getRandom(int size) {
        QueryWrapper<SingleQuestion> wrapper = new QueryWrapper<>();
        Integer all = singleQuestionMapper.selectCount( wrapper );
        int[] arr = Utils.random( all, size );
        for (int i = 0; i <= arr.length-1; i++) {
            wrapper.eq( "id", arr[i] ).or();
        }
        wrapper.eq( "id", arr[arr.length - 1] );
        return singleQuestionMapper.selectList( wrapper );
    }

    @Override
    public IPage<SingleQuestion> getAll(Page<SingleQuestion> page) {
        return singleQuestionMapper.selectPage( page, new QueryWrapper<>() );
    }
}
