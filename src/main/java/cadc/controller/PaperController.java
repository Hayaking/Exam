package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.bean.message.STATE;
import cadc.entity.Paper;
import cadc.entity.User;
import cadc.service.*;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static cadc.bean.message.STATE.*;

/**
 * @author haya
 */
@Log4j2
@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @Autowired
    private ExamService examService;

    /**
     * 生成随机试卷
     *
     * @param examId
     * @param jSize
     * @param eSize
     * @param mSize
     * @param sSize
     * @return
     */
    @RequestMapping(value = "/paper/generate/{examId}/{eSize}/{jSize}/{mSize}/{sSize}", method = RequestMethod.GET)
    public Object generatePaper(@PathVariable int examId, @PathVariable int jSize, @PathVariable int eSize, @PathVariable int mSize, @PathVariable int sSize) {
        Subject subject = SecurityUtils.getSubject();
        // 判断是否已经有老师创建的试卷
        if ("teacher_done".equals( examService.getById( examId ).getPaperState() )) {
            return MessageFactory.message( FAILED );
        }
        // 将考试的试卷状态标志为老师创建
        if (subject.hasRole( "老师" )) {
            examService.updatePaperState( examId, "teacher_done" );
        }
        // 生成随机试卷
        User user = (User) subject.getPrincipal();
        String account = user.getAccount();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Map<String, Object> res = paperService.generatePaper(
                new Paper( account, sdf.format( new Date() ), examId ),
                eSize, jSize, mSize, sSize );
        return MessageFactory.message( SUCCESS, res );
    }
}
