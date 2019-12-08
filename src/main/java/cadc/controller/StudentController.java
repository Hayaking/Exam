package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.entity.User;
import cadc.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static cadc.bean.message.STATE.FAILED;
import static cadc.bean.message.STATE.SUCCESS;

/**
 * @author haya
 */
@Log4j2
@RestController
@RequestMapping
public class StudentController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/student/{name}", method = RequestMethod.GET)
    public Object getStudentByName(@PathVariable String name) {
        return MessageFactory.message( SUCCESS, userService.getByName( name ));
    }
    @RequiresRoles( "老师" )
    @RequestMapping(value = "/user/students/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public Object getStudents(@PathVariable int pageNum, @PathVariable int pageSize) {
        IPage<User> all = userService.getAllStudent( new Page<>( pageNum, pageSize ) );
        return MessageFactory.message( SUCCESS, all );
    }
    @RequiresRoles( "老师" )
    @RequestMapping(value = "/user/students/{pageNum}/{pageSize}/{clazz}", method = RequestMethod.GET)
    public Object getStudentsByClazz(@PathVariable int pageNum, @PathVariable int pageSize, @PathVariable String clazz) {
        IPage<User> all = userService.getByClazz( new Page<>( pageNum, pageSize ), clazz );
        return MessageFactory.message( SUCCESS, all );
    }
    @RequiresRoles( "老师" )
    @RequestMapping(value = "/user/students/{pageNum}/{pageSize}/{schoolId}", method = RequestMethod.GET)
    public Object getStudentsBySchool(@PathVariable int pageNum, @PathVariable int pageSize, @PathVariable int schoolId) {
        IPage<User> all = userService.getBySchool( new Page<>( pageNum, pageSize ), schoolId );
        return MessageFactory.message( SUCCESS, all );
    }

    @RequiresRoles( "老师" )
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Object getStudentsBySchool(@PathVariable int id) {
        boolean flag = userService.delete( id );
        return MessageFactory.message( flag ? SUCCESS : FAILED );
    }
}
