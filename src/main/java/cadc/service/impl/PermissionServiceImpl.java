package cadc.service.impl;

import cadc.entity.Permission;
import cadc.entity.PermissionMenu;
import cadc.entity.RolePermission;
import cadc.mapper.PermissionMapper;
import cadc.mapper.PermissionMenuMapper;
import cadc.mapper.RolePermissionMapper;
import cadc.service.PermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haya
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private RolePermissionMapper rolePermissionMapper;
    @Resource
    private PermissionMenuMapper permissionMenuMapper;

    @Override

    public List<Permission> getPermissionList(int roleId) {
        return permissionMapper.getList( roleId );
    }

}
