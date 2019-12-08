package cadc.service.impl;

import cadc.entity.UserRole;
import cadc.mapper.UserRoleMapper;
import cadc.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author haya
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements UserRoleService {
}
