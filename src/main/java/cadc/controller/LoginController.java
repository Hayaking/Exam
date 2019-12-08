package cadc.controller;

import cadc.bean.UserToken;
import cadc.bean.message.MessageFactory;
import cadc.entity.User;
import cadc.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static cadc.bean.message.STATE.FAILED;
import static cadc.bean.message.STATE.SUCCESS;

/**
 * @author haya
 */
@Log4j2
@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(String account, String password) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return MessageFactory.message( SUCCESS, subject.getSession().getId() );
        }
        subject.login( new UserToken( account, password ) );
        if (subject.isAuthenticated()) {
            return MessageFactory.message( SUCCESS, subject.getSession().getId() );
        }
        return MessageFactory.message( SUCCESS, "" );
    }

    /**
     * 登出
     *
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Object logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            return MessageFactory.message( SUCCESS, "登出成功" );
        }
        return MessageFactory.message( FAILED, "登出失败" );
    }

    @RequiresAuthentication
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Object getUserInfo() {
        log.warn( "info" );
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        log.warn( user );
        String account = user.getAccount();
        user = userService.getByAccount( account );
        return MessageFactory.message( SUCCESS, user );
    }
}
