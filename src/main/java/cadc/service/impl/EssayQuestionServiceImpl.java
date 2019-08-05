package cadc.service.impl;

import cadc.entity.EssayQuestion;
import cadc.mapper.EssayQuestionMapper;
import cadc.service.EssayQuestionService;
import cadc.util.Utils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haya
 */
@Log4j2
@Service
@Transactional(rollbackFor = Exception.class)
public class EssayQuestionServiceImpl extends ServiceImpl<EssayQuestionMapper, EssayQuestion> implements EssayQuestionService {
    @Resource
    private EssayQuestionMapper essayQuestionMapper;

    @Override
    public List<EssayQuestion> getRandom(int size) {
        QueryWrapper<EssayQuestion> wrapper = new QueryWrapper<>();
        Integer all = essayQuestionMapper.selectCount( wrapper );
        if (size < all) {
            int[] arr = Utils.random( all, size );
            for (int i = 0; i <= arr.length-1; i++) {
                wrapper.eq( "id", arr[i] ).or();
            }
            wrapper.eq( "id", arr[arr.length - 1] );
        }

        return essayQuestionMapper.selectList( wrapper );
    }

    @Override
    public IPage<EssayQuestion> getAll(Page<EssayQuestion> page) {
        return essayQuestionMapper.selectPage( page, new QueryWrapper<>() );
    }
}
