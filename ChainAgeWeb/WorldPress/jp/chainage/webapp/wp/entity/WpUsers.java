package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpUsers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_users", schema = "")
public class WpUsers implements java.io.Serializable {
    private static final long serialVersionUID = -5644597627610289906L;

    // Fields
    private Long id;
    private String userLogin;
    private String userPass;
    private String userNicename;
    private String userEmail;
    private String userUrl;
    private Timestamp userRegistered;
    private String userActivationKey;
    private Integer userStatus;
    private String displayName;

    // Constructors

    /** default constructor */
    public WpUsers() {}

    /** full constructor */
    public WpUsers(String userLogin, String userPass, String userNicename, String userEmail, String userUrl, Timestamp userRegistered, String userActivationKey, Integer userStatus,
            String displayName) {
        this.userLogin = userLogin;
        this.userPass = userPass;
        this.userNicename = userNicename;
        this.userEmail = userEmail;
        this.userUrl = userUrl;
        this.userRegistered = userRegistered;
        this.userActivationKey = userActivationKey;
        this.userStatus = userStatus;
        this.displayName = displayName;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_login", nullable = false, length = 60)

    public String getUserLogin() {
        return this.userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Column(name = "user_pass", nullable = false)

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Column(name = "user_nicename", nullable = false, length = 50)

    public String getUserNicename() {
        return this.userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    @Column(name = "user_email", nullable = false, length = 100)

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "user_url", nullable = false, length = 100)

    public String getUserUrl() {
        return this.userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    @Column(name = "user_registered", nullable = false, length = 19)

    public Timestamp getUserRegistered() {
        return this.userRegistered;
    }

    public void setUserRegistered(Timestamp userRegistered) {
        this.userRegistered = userRegistered;
    }

    @Column(name = "user_activation_key", nullable = false)

    public String getUserActivationKey() {
        return this.userActivationKey;
    }

    public void setUserActivationKey(String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    @Column(name = "user_status", nullable = false)

    public Integer getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Column(name = "display_name", nullable = false, length = 250)

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
