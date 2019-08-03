package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.entity.Exam;
import cadc.entity.User;
import cadc.service.ExamService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static cadc.bean.message.STATE.FAILED;
import static cadc.bean.message.STATE.SUCCESS;

/**
 * @author haya
 */
@Log4j2
@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping(value = "/exam", method = RequestMethod.POST)
    public Object addExam(@RequestBody Exam exam) {
        boolean flag;
        if (exam.getId() == 0) {
            flag = exam.insert();
        } else {
            flag = exam.updateById();
        }
        return MessageFactory.message( flag ? SUCCESS : FAILED );
    }

    @RequestMapping(value = "/exam/{id}", method = RequestMethod.DELETE)
    public Object addExam(@PathVariable String id) {
        boolean flag = examService.removeById( id );
        return MessageFactory.message( flag ? SUCCESS : FAILED );
    }

    @RequestMapping(value = "/exam/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public Object getStudents(@PathVariable int pageNum, @PathVariable int pageSize) {
        IPage<Exam> all = examService.getAllExam( new Page<>( pageNum, pageSize ) );
        return MessageFactory.message( SUCCESS, all );
    }
}
