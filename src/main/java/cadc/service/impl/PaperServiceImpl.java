package cadc.service.impl;

import cadc.entity.*;
import cadc.mapper.PaperMapper;
import cadc.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

    @Resource
    private PaperMapper paperMapper;
    @Autowired
    private PaperQuestionService paperQuestionService;
    @Autowired
    private EssayQuestionService essayQuestionService;
    @Autowired
    private SingleQuestionService singleQuestionService;
    @Autowired
    private MultiQuestionService multiQuestionService;
    @Autowired
    private JudgeQuestionService judgeQuestionService;

    @Override
    public Map<String, Object> generatePaper(Paper paper, int eSize, int jSize, int mSize, int sSize) {
        paper.insert();
        HashMap<String, Object> map = new HashMap<>( 5 );
        map.put( "paper", paper );
        map.put( "essay", essayQuestionService.getRandom( eSize ) );
        map.put( "judge", judgeQuestionService.getRandom( eSize ) );
        map.put( "multi", multiQuestionService.getRandom( eSize ) );
        map.put( "single", singleQuestionService.getRandom( eSize ) );
        paperQuestionService.insertList( map );
        return map;
    }

    @Override
    public Map<String, Object> getByExamId(int examId) {
        QueryWrapper<Paper> paperQueryWrapper = new QueryWrapper<>();
        paperQueryWrapper.eq( "exam_id", examId );
        HashMap<String, Object> map = new HashMap<>( 5 );
        Paper paper = paperMapper.selectOne( paperQueryWrapper );
        int paperId = paper.getId();
        map.put( "paper",  paper);
        map.put( "essay",paperQuestionService.getEssayByPaperId( paperId ) );
        map.put( "judge", paperQuestionService.getJudgeByPaperId( paperId ) );
        map.put( "multi", paperQuestionService.getMultiByPaperId( paperId ) );
        map.put( "single", paperQuestionService.getSingleByPaperId( paperId ) );
        return map;
    }


}
