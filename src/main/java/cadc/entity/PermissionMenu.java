package cadc.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author haya
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("permission_menu")
public class PermissionMenu extends Model<PermissionMenu> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private int id;
    private int permissionId;
    private int menuId;

    public PermissionMenu() {
    }

    public PermissionMenu(int permissionId, int menuId) {
        this.permissionId = permissionId;
        this.menuId = menuId;
    }
}
