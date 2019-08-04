package cadc.controller;

import cadc.bean.QuestionFactory;
import cadc.bean.message.MessageFactory;
import cadc.bean.message.STATE;
import cadc.entity.*;
import cadc.service.EssayQuestionService;
import cadc.service.JudgeQuestionService;
import cadc.service.MultiQuestionService;
import cadc.service.SingleQuestionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static cadc.bean.message.STATE.STATE_INVITE_SUCCESS;
import static cadc.bean.message.STATE.SUCCESS;

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


    @RequestMapping(value = "/questions/{type}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public Object getAllQuestion(@PathVariable String type, @PathVariable int pageNum, @PathVariable int pageSize) {
        Object res = null;
        switch (type) {
            case "single":
                res = singleQuestionService.getAll( new Page<>( pageNum, pageSize ) );
                break;
            case "judge":
                res = judgeQuestionService.getAll( new Page<>( pageNum, pageSize ) );
                break;
            case "multi":
                res = multiQuestionService.getAll( new Page<>( pageNum, pageSize ) );
                break;
            case "essay":
                res = essayQuestionService.getAll( new Page<>( pageNum, pageSize ) );
                break;
            default:
                break;
        }
        return MessageFactory.message( SUCCESS, res );
    }

    @RequestMapping(value = "/question/{type}", method = RequestMethod.POST)
    public Object saveQuestion(@RequestBody Map<String, String> object, @PathVariable String type) {

        switch (type) {
            case "single":
                SingleQuestion singleQuestion = QuestionFactory.singleQuestionFactory( object );
                if (singleQuestion.getId() == 0) {
                    singleQuestion.insert();
                } else {
                    singleQuestion.updateById();
                }
                break;
            case "judge":
                JudgeQuestion judgeQuestion = (JudgeQuestion) object;
                if (judgeQuestion.getId() == 0) {
                    judgeQuestion.insert();
                } else {
                    judgeQuestion.updateById();
                }
                break;
            case "multi":
                MultiQuestion multiQuestion = (MultiQuestion) object;
                if (multiQuestion.getId() == 0) {
                    multiQuestion.insert();
                } else {
                    multiQuestion.updateById();
                }
                break;
            case "essay":
                EssayQuestion essayQuestion = (EssayQuestion) object;
                if (essayQuestion.getId() == 0) {
                    essayQuestion.insert();
                } else {
                    essayQuestion.updateById();
                }
                break;
            default:
                break;
        }
        return MessageFactory.message( SUCCESS );
    }

    @RequestMapping(value = "/question/{type}/{id}", method = RequestMethod.DELETE)
    public Object deleteSingleQuestion(@PathVariable String type, @PathVariable String id) {
        switch (type) {
            case "single":
                singleQuestionService.removeById( id );
                break;
            case "judge":
                judgeQuestionService.removeById( id );
                break;
            case "multi":
                multiQuestionService.removeById( id );
                break;
            case "essay":
                essayQuestionService.removeById( id );
                break;
            default:
                break;
        }
        return MessageFactory.message( SUCCESS );
    }
    @RequestMapping(value = "/question/test", method = RequestMethod.GET)
    public Object test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put( "essay", essayQuestionService.getRandom( 5 ) );
        map.put( "judge", judgeQuestionService.getRandom( 5 ) );
        map.put( "single", singleQuestionService.getRandom( 5 ) );
        map.put( "multi", multiQuestionService.getRandom( 5 ) );
        return map;
    }
}
