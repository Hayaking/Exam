package cadc.service;

import cadc.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author haya
 */
public interface UserService extends IService<User> {
    User get(String account, String password);

    boolean add(User user);

    boolean delete(int id);

    boolean deleteByAccount(String account);

    User getByAccount(String account);

    User getByName(String name);

    /**
     * 获取所有的用户信息
     * @param page 分页
     * @return
     */
    IPage<User> getAll(Page<User> page);

    IPage<User> getByClazz(Page<User> page, String clazz);

    IPage<User> getBySchool(Page<User> page, int schoolId);

    boolean update(String account, User user);
}
