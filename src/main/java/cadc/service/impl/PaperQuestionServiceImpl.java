package cadc.service.impl;

import cadc.entity.*;
import cadc.mapper.PaperQuestionMapper;
import cadc.service.PaperQuestionService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author haya
 */
@Service
public class PaperQuestionServiceImpl extends ServiceImpl<PaperQuestionMapper, PaperQuetion> implements PaperQuestionService {
    @Resource
    private PaperQuestionMapper paperQuestionMapper;

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
}
