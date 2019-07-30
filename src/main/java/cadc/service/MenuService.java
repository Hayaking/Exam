package cadc.service;


import cadc.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author haya
 */
public interface MenuService extends IService<Menu> {
    List<Menu> getMenu(String account);
}
