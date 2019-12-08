package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.bean.message.STATE;
import cadc.entity.PaperDone;
import cadc.service.PaperDoneService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static cadc.bean.message.STATE.FAILED;
import static cadc.bean.message.STATE.SUCCESS;

/**
 * @author haya
 */
@RestController
public class PaperDoneController {
    @Autowired
    private PaperDoneService paperDoneService;

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public Object check(@RequestBody PaperDone paperDone) {
//        int userId = paperDone.getUserId();
//        int paperId = paperDone.getPaperId();
//        PaperDone obj = paperDoneService.getByUserAndPaperId( userId, paperId );
//        if (obj != null) {
//            return MessageFactory.message( SUCCESS, obj.getId() );
//        }
        boolean flag = paperDone.insertOrUpdate();
        return MessageFactory.message( flag ? SUCCESS : FAILED, paperDone.getId() );
    }

    @RequestMapping(value = "/done/{id}", method = RequestMethod.DELETE)
    public Object delete( @PathVariable int id) {
        paperDoneService.removeById( id );
        return MessageFactory.message(  SUCCESS);
    }

    @RequestMapping(value = "/done/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public Object getAll(@PathVariable int pageNum, @PathVariable int pageSize) {
        IPage<PaperDone> all = paperDoneService.getAll( new Page<>( pageNum, pageSize ) );
        return MessageFactory.message( SUCCESS ,all );
    }
}
