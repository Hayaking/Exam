package cadc.controller;

import cadc.entity.User;
import cadc.service.MenuService;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haya
 */
@Log4j2
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 接收前端传来的type
     * 返回路由菜单
     * @return
     */
    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public Object menu( ) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        String account = user.getAccount();
        return menuService.getMenu( account );
    }


}
