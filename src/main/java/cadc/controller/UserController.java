package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.bean.message.STATE;
import cadc.entity.User;
import cadc.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static cadc.bean.message.STATE.SUCCESS;

/**
 * @author haya
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/student/{name}", method = RequestMethod.GET)
    public Object getStudentByName(@PathVariable String name) {
        return null;
    }

    @RequestMapping(value = "/user/students/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public Object getStudents(@PathVariable int pageNum, @PathVariable int pageSize) {
        IPage<User> all = userService.getAll( new Page<>( pageNum, pageSize ) );
        return MessageFactory.message( SUCCESS, all );
    }

    @RequestMapping(value = "/user/students/{pageNum}/{pageSize}/{clazz}", method = RequestMethod.GET)
    public Object getStudentsByClazz(@PathVariable int pageNum, @PathVariable int pageSize, @PathVariable String clazz) {
        IPage<User> all = userService.getByClazz( new Page<>( pageNum, pageSize ), clazz );
        return MessageFactory.message( SUCCESS, all );
    }

    @RequestMapping(value = "/user/students/{pageNum}/{pageSize}/{schoolId}", method = RequestMethod.GET)
    public Object getStudentsByClazz(@PathVariable int pageNum, @PathVariable int pageSize, @PathVariable int schoolId) {
        IPage<User> all = userService.getBySchool( new Page<>( pageNum, pageSize ), schoolId );
        return MessageFactory.message( SUCCESS, all );
    }
}
