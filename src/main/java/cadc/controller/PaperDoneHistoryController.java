package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.entity.PaperDoneHistory;
import cadc.service.PaperDoneHistoryService;
import cadc.service.PaperDoneService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cadc.bean.message.STATE.SUCCESS;

/**
 * @author haya
 */
@Log4j2
@RestController
public class PaperDoneHistoryController {
    @Autowired
    private PaperDoneHistoryService paperDoneHistoryService;
    @Autowired
    private PaperDoneService paperDoneService;

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public Object check(@RequestBody List<PaperDoneHistory> list) {
        int doneId = list.get( 0 ).getPaperDoneId();
        paperDoneHistoryService.saveBatch( list );
        Double score = paperDoneService.sumScore( list );
        paperDoneService.updateScore( doneId, score );
        return MessageFactory.message( SUCCESS, score );
    }
}
