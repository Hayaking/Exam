package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.entity.Exam;
import cadc.entity.User;
import cadc.service.ExamService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cadc.bean.message.STATE.FAILED;
import static cadc.bean.message.STATE.SUCCESS;
import static org.apache.ibatis.ognl.DynamicSubscript.all;

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
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            exam.setExamCreator( user.getId() );
            exam.setPaperState( "random" );
            exam.setExamState( "no" );
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

    @RequestMapping(value = "/exam/{name}", method = RequestMethod.GET)
    public Object getStudents(@PathVariable String name) {
        Exam exam = examService.getByName( name );
        return MessageFactory.message( SUCCESS, exam );
    }

    @RequestMapping(value = "/exam", method = RequestMethod.GET)
    public Object getNo() {
        List<Exam> all = examService.getNoExam();
        return MessageFactory.message( SUCCESS, all );
    }
}
