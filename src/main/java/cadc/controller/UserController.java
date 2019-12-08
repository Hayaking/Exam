package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.bean.message.STATE;
import cadc.entity.Role;
import cadc.entity.User;
import cadc.entity.UserRole;
import cadc.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public Object upDateStudent(@RequestBody User user) {
        boolean flag = user.insertOrUpdate();
        UserRole userRole = new UserRole( user.getId(), 2 );
        userRole.insertOrUpdate();
        return MessageFactory.message( flag ? SUCCESS : FAILED );
    }

}
