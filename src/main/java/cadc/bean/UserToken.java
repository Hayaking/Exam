package cadc.bean;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author haya
 */
public class UserToken extends UsernamePasswordToken {
    private String loginType;

    public UserToken() {}

    public UserToken(final String username, final String password,
                     final String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public UserToken(String username, String password) {
        super( username, password );
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}
