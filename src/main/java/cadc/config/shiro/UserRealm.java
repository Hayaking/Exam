package cadc.config.shiro;


import cadc.bean.UserToken;
import cadc.entity.Permission;
import cadc.entity.Role;
import cadc.entity.User;
import cadc.service.PermissionService;
import cadc.service.RoleService;
import cadc.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author haya
 */
@Log4j2
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 登录成功后 获取角色、权限等信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) getAvailablePrincipal( principalCollection );
        Set<String> roles = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 查找用户拥有的角色
        List<Role> roleList = roleService.getRoleList( user.getAccount() );
        // 找到角色拥有的权限
        for (Role item : roleList) {
            roles.add( item.getRoleName() );
            List<Permission> permissionList = permissionService.getPermissionList( item.getId() );
            for (Permission item2 : permissionList) {
                info.addStringPermission( item2.getPermissionName() );
            }
        }
        info.setRoles( roles );
        return null;
    }

    /**
     * 登录验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UserToken userToken = (UserToken) token;
        String account = (String) userToken.getPrincipal();
        String passWord = new String( (char[]) userToken.getCredentials() );
        String loginType = userToken.getLoginType();
        User user = userService.get( account, passWord );
        if (user == null || user.getAccount() == null) {
            throw new UnknownAccountException();
        }
        user.setPassword( "" );
        SecurityUtils.getSubject().getSession().setAttribute("userInfo", user);
        return new SimpleAuthenticationInfo( user, passWord, getName() );
    }
}
