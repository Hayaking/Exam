package cadc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * @author haya
 */
@Data
@TableName("user_role")
public class UserRole  extends Model<UserRole> implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;
    private int userId;
    private int roleId;

    public UserRole() {
    }

    public UserRole(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
