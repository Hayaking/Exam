package cadc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("role_permission")
public class RolePermission extends Model<RolePermission> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private int id;
    private int roleId;
    private int permissionId;

    public RolePermission() {
    }

    public RolePermission(int roleId, int permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }
}
