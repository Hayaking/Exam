package cadc.service.impl;

import cadc.entity.*;
import cadc.mapper.*;
import cadc.service.PaperQuestionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haya
 */
@Service
public class PaperQuestionServiceImpl extends ServiceImpl<PaperQuestionMapper, PaperQuetion> implements PaperQuestionService {
    @Resource
    private PaperQuestionMapper paperQuestionMapper;
    @Resource
    private SingleQuestionMapper singleQuestionMapper;
    @Resource
    private MultiQuestionMapper multiQuestionMapper;
    @Resource
    private JudgeQuestionMapper judgeQuestionMapper;
    @Resource
    private EssayQuestionMapper essayQuestionMapper;
    @Override
    public boolean insertList(HashMap<String, Object> map) {
        Paper paper = (Paper) map.get( "paper" );
        int paperId = paper.getId();
        List<SingleQuestion> singles = (List<SingleQuestion>) map.get( "single" );
        for (SingleQuestion item : singles) {
            new PaperQuetion( paperId, item.getId(), "single" ).insert();
        }
        List<MultiQuestion> multis = (List<MultiQuestion>) map.get( "multi" );
        for (MultiQuestion item : multis) {
            new PaperQuetion( paperId, item.getId(), "multi" ).insert();
        }
        List<JudgeQuestion> judges = (List<JudgeQuestion>) map.get( "judge" );
        for (JudgeQuestion item : judges) {
            new PaperQuetion( paperId, item.getId(), "judge" ).insert();
        }
        List<EssayQuestion> essays = (List<EssayQuestion>) map.get( "essay" );
        for (EssayQuestion item : essays) {
            new PaperQuetion( paperId, item.getId(), "essay" ).insert();
        }
        return true;
    }

    @Override
    public List<SingleQuestion> getSingleByPaperId(int paperId) {
        QueryWrapper<PaperQuetion> wrapper = new QueryWrapper<>();
        wrapper.eq( "paper_id", paperId ).eq( "question_type","single" );
        List<PaperQuetion> list = paperQuestionMapper.selectList( wrapper );
        List<SingleQuestion> res = new LinkedList<>();
        for (PaperQuetion item : list) {
            res.add( singleQuestionMapper.selectById( item.getQuestionId() ) );
        }
        return res;
    }

    @Override
    public List<MultiQuestion> getMultiByPaperId(int paperId) {
        QueryWrapper<PaperQuetion> wrapper = new QueryWrapper<>();
        wrapper.eq( "paper_id", paperId ).eq( "question_type","multi" );
        List<PaperQuetion> list = paperQuestionMapper.selectList( wrapper );
        List<MultiQuestion> res = new LinkedList<>();
        for (PaperQuetion item : list) {
            res.add( multiQuestionMapper.selectById( item.getQuestionId() ) );
        }
        return res;
    }

    @Override
    public List<JudgeQuestion> getJudgeByPaperId(int paperId) {
        QueryWrapper<PaperQuetion> wrapper = new QueryWrapper<>();
        wrapper.eq( "paper_id", paperId ).eq( "question_type","judge" );
        List<PaperQuetion> list = paperQuestionMapper.selectList( wrapper );
        List<JudgeQuestion> res = new LinkedList<>();
        for (PaperQuetion item : list) {
            res.add( judgeQuestionMapper.selectById( item.getQuestionId() ) );
        }
        return res;
    }

    @Override
    public List<EssayQuestion> getEssayByPaperId(int paperId) {
        QueryWrapper<PaperQuetion> wrapper = new QueryWrapper<>();
        wrapper.eq( "paper_id", paperId ).eq( "question_type","essay" );
        List<PaperQuetion> list = paperQuestionMapper.selectList( wrapper );
        List<EssayQuestion> res = new LinkedList<>();
        for (PaperQuetion item : list) {
            res.add( essayQuestionMapper.selectById( item.getQuestionId() ) );
        }
        return res;
    }
}
