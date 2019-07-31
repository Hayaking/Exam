package cadc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("user")
public class User extends Model<User> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private int id;
    private String account;
    private String password;
    private String clazz;
    private String name;
    private String sex;
    @TableField(exist = false)
    private String schoolName;
}
