package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.bean.message.STATE;
import cadc.entity.Paper;
import cadc.entity.User;
import cadc.service.*;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static cadc.bean.message.STATE.STATE_INVITE_SUCCESS;

/**
 * @author haya
 */
@Log4j2
@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    @RequestMapping(value = "/paper/generate/{examId}/{eSize}/{jSize}/{mSize}/{sSize}",method = RequestMethod.GET)
    public Object generatePaper(@PathVariable int examId, @PathVariable int jSize, @PathVariable int eSize, @PathVariable int mSize, @PathVariable int sSize) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String account = user.getAccount();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Paper paper = new Paper( account, sdf.format( new Date() ), examId );
        Map<String, Object> res = paperService.generatePaper( paper, eSize, jSize, mSize, sSize );
        return MessageFactory.message( STATE_INVITE_SUCCESS,res );
    }
}
