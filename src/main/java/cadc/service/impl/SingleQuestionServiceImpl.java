package cadc.service.impl;

import cadc.entity.SingleQuestion;
import cadc.mapper.SingleQuestionMapper;
import cadc.service.SingleQuestionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author LZY
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SingleQuestionServiceImpl extends ServiceImpl<SingleQuestionMapper, SingleQuestion> implements SingleQuestionService {
    @Resource
    private SingleQuestionMapper singleQuestionMapper;
    @Override
    public List<SingleQuestion> getRandom(int size) {
        QueryWrapper<SingleQuestion> wrapper = new QueryWrapper<>();
        Integer sum = singleQuestionMapper.selectCount(wrapper);
        List<SingleQuestion> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {

            list.add(getById((Math.random()) * sum));
        }
        return list;
    }

    @Override
    public boolean add(SingleQuestion singleQuestion) {

        return singleQuestionMapper.insert(singleQuestion) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public SingleQuestion getById(int id) {
        QueryWrapper<SingleQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return singleQuestionMapper.selectOne(wrapper);
    }
}
