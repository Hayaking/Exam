package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.entity.Exam;
import cadc.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import static cadc.bean.message.STATE.FAILED;
import static cadc.bean.message.STATE.SUCCESS;

/**
 * @author haya
 */
@Log4j2
@RestController
public class ExamController {

    @RequestMapping(value = "/exam", method = RequestMethod.POST)
    public Object addExam(@RequestBody Exam exam) {
        boolean flag = exam.insert();
        return MessageFactory.message( flag ? SUCCESS : FAILED );
    }

    @RequestMapping(value = "/exam/{id}", method = RequestMethod.DELETE)
    public Object addExam(@PathVariable String id) {
        boolean flag = false;
        return MessageFactory.message( flag ? SUCCESS : FAILED );
    }
}
