package cadc.service;

import cadc.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface RoleService extends IService<Role> {
    /**
     * 根据用户账号获取其拥有的角色列表
     * @param account
     * @return
     */
    List<Role> getRoleList(String account);

}
