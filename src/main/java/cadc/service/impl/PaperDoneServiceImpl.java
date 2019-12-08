package cadc.service.impl;

import cadc.entity.*;
import cadc.mapper.*;
import cadc.service.PaperDoneService;
import cadc.service.UserService;
import cadc.util.Utils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haya
 */
@Service
public class PaperDoneServiceImpl extends ServiceImpl<PaperDoneMapper, PaperDone> implements PaperDoneService {

    @Resource
    private PaperDoneMapper paperDoneMapper;
    @Resource
    private SingleQuestionMapper singleQuestionMapper;
    @Resource
    private MultiQuestionMapper multiQuestionMapper;
    @Resource
    private JudgeQuestionMapper judgeQuestionMapper;
    @Resource
    private EssayQuestionMapper essayQuestionMapper;
    @Autowired
    private UserService userService;
    @Override
    public PaperDone getByUserAndPaperId(int userId, int paperId) {
        QueryWrapper<PaperDone> wrapper = new QueryWrapper<>();
        wrapper.eq( "user_id", userId ).eq( "paper_id", paperId );
        return paperDoneMapper.selectOne( wrapper );
    }

    @Override
    public Double sumScore(List<PaperDoneHistory> list) {
        Double sum = 0.0;
        String answer, userAnswer;
        for (PaperDoneHistory item : list) {
            switch (item.getQuestionType()) {
                case "single":
                    SingleQuestion singleQuestion = singleQuestionMapper.selectById( item.getQuestionId() );
                    answer = singleQuestion.getAnswer();
                    userAnswer = item.getUserAnswer();
                    if (answer.equals( userAnswer )) {
                        sum += singleQuestion.getScore();
                    }
                    break;
                case "multi":
                    MultiQuestion multiQuestion = multiQuestionMapper.selectById(item.getQuestionId() );
                    answer = Utils.remove1( multiQuestion.getAnswer() );
                    userAnswer = Utils.remove1( item.getUserAnswer() );
                    if (answer.equals( userAnswer )) {
                        sum += multiQuestion.getScore();
                    }
                    break;
                case "judge":
                    JudgeQuestion judgeQuestion = judgeQuestionMapper.selectById( item.getQuestionId() );
                    answer = judgeQuestion.getAnswer();
                    userAnswer = item.getUserAnswer();
                    if (answer.equals( userAnswer )) {
                        sum += judgeQuestion.getScore();
                    }
                    break;
                case "essay":
                    break;
                default:
                    break;
            }
        }
        return sum;
    }

    @Override
    public boolean updateScore(int id, Double score) {
        return paperDoneMapper.updateSumScore( id, score ) > 0;
    }

    @Override
    public IPage<PaperDone> getAll(Page<PaperDone> page) {
        QueryWrapper<PaperDone> wrapper = new QueryWrapper<>();
        List<PaperDone> list = paperDoneMapper.selectList( wrapper );
        for (PaperDone item : list) {
            item.setUserName( userService.getNameById( item.getUserId() ) );
        }
        return page.setRecords( list );
    }
}
