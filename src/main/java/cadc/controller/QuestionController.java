package cadc.controller;

import cadc.entity.SingleQuestion;
import cadc.service.EssayQuestionService;
import cadc.service.JudgeQuestionService;
import cadc.service.MultiQuestionService;
import cadc.service.SingleQuestionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author haya
 */
@Log4j2
@RestController
public class QuestionController {
    @Autowired
    private EssayQuestionService essayQuestionService;
    @Autowired
    private SingleQuestionService singleQuestionService;
    @Autowired
    private MultiQuestionService multiQuestionService;
    @Autowired
    private JudgeQuestionService judgeQuestionService;

    @RequestMapping(value = "/question/{type}/{id}", method = RequestMethod.GET)
    public Object getQuestion(@PathVariable int id, @PathVariable String type) {
        switch (type) {
            case "single":
                return singleQuestionService.getById( id );
            case "judge":
                return judgeQuestionService.getById( id );
            case "multi":
                return multiQuestionService.getById( id );
            case "essay":
                return essayQuestionService.getById( id );
                default:
                    break;

        }
        return null;
    }


}
