package cadc.controller;

import cadc.bean.message.MessageFactory;
import cadc.entity.Permission;
import cadc.service.PermissionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 获取指定角色拥有的权限
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/permission/{roleId}", method = RequestMethod.GET)
    public Object getByRoleId(@PathVariable int roleId) {
        List<Permission> list = permissionService.getPermissionList( roleId );
        return MessageFactory.message( SUCCESS, list );
    }

    /**
     * 获取所有权限
     *
     * @return
     */
    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public Object getAll() {
        List<Permission> list = permissionService.list();
        return MessageFactory.message( SUCCESS, list );
    }


}
