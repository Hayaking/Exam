package cadc.service.impl;

import cadc.entity.User;
import cadc.mapper.UserMapper;
import cadc.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author haya
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User get(String account, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq( "account", account ).eq( "password", password );
        return userMapper.selectOne( wrapper );
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean deleteByAccount(String account) {
        return false;
    }

    @Override
    public User getByAccount(String account) {
        return null;
    }

    @Override
    public User getByName(String name) {
        return null;
    }

    @Override
    public IPage<User> getAll(Page<User> page) {
        return null;
    }

    @Override
    public IPage<User> getByClazz(Page<User> page, String clazz) {
        return null;
    }

    @Override
    public IPage<User> getBySchool(Page<User> page, int schoolId) {
        return null;
    }

    @Override
    public boolean update(String account, User user) {
        return false;
    }

}
