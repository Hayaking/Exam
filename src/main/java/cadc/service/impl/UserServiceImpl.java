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
        wrapper.eq("account", account).eq("password", password);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public boolean add(User user) {
        int res = userMapper.insert(user);
        return res > 0;
    }

    @Override
    public boolean delete(int id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByAccount(String account) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account",account);
        return userMapper.delete(wrapper) > 0;
    }

    @Override
    public User getByAccount(String account) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("account", account);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public User getByName(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public IPage<User> getAll(Page<User> page) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectPage(page, wrapper);
    }

    @Override

    public IPage<User> getByClazz(Page<User> page, String clazz) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("clazz", clazz);
        return userMapper.selectPage(page, wrapper);
    }

    @Override
    public IPage<User> getBySchool(Page<User> page, int schoolId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("school_id", schoolId);
        return userMapper.selectPage(page, wrapper);
    }

    @Override
    public boolean update(String account, User user) {
        return false;
    }

}
