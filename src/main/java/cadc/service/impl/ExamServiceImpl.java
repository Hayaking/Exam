package cadc.service.impl;

import cadc.entity.Exam;
import cadc.mapper.ExamMapper;
import cadc.service.ExamService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author haya
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Resource
    private ExamMapper examMapper;


    @Override
    public IPage<Exam> getAllExam(Page<Exam> page) {
        return examMapper.selectPage( page, new QueryWrapper<>() );
    }
    @Override
    public boolean updatePaperState(int id, String state) {
        return examMapper.updatePaperState( id, state ) > 0;
    }
}
