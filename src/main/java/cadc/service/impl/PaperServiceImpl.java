package cadc.service.impl;

import cadc.entity.Paper;
import cadc.mapper.PaperMapper;
import cadc.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

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
        HashMap<String, Object> map = new HashMap<>( 5 );
        map.put( "paper", paper );
        map.put( "essay", essayQuestionService.getRandom( eSize ) );
        map.put( "judge", judgeQuestionService.getRandom( eSize ) );
        map.put( "multi", multiQuestionService.getRandom( eSize ) );
        map.put( "single", singleQuestionService.getRandom( eSize ) );
        return map;
    }
}
