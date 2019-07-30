package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.bean.message.STATE;
import cadc.service.PaperDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author haya
 */
@RestController
public class PaperDoneController {
    @Autowired
    private PaperDoneService paperDoneService;

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public Object check(@RequestBody Map<String, Object> map) {

        return MessageFactory.message( STATE.SUCCESS);
    }
}
