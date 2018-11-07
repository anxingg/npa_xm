package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpSignups entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_signups", schema = "")
public class WpSignups implements java.io.Serializable {
    private static final long serialVersionUID = -3916375258644583141L;

    // Fields
    private Long signupId;
    private String domain;
    private String path;
    private String title;
    private String userLogin;
    private String userEmail;
    private Timestamp registered;
    private Timestamp activated;
    private Boolean active;
    private String activationKey;
    private String meta;

    // Constructors

    /** default constructor */
    public WpSignups() {}

    /** minimal constructor */
    public WpSignups(String domain, String path, String title, String userLogin, String userEmail, Timestamp registered, Timestamp activated, Boolean active,
            String activationKey) {
        this.domain = domain;
        this.path = path;
        this.title = title;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.registered = registered;
        this.activated = activated;
        this.active = active;
        this.activationKey = activationKey;
    }

    /** full constructor */
    public WpSignups(String domain, String path, String title, String userLogin, String userEmail, Timestamp registered, Timestamp activated, Boolean active, String activationKey,
            String meta) {
        this.domain = domain;
        this.path = path;
        this.title = title;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.registered = registered;
        this.activated = activated;
        this.active = active;
        this.activationKey = activationKey;
        this.meta = meta;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "signup_id", unique = true, nullable = false)

    public Long getSignupId() {
        return this.signupId;
    }

    public void setSignupId(Long signupId) {
        this.signupId = signupId;
    }

    @Column(name = "domain", nullable = false, length = 200)

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Column(name = "path", nullable = false, length = 100)

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "title", nullable = false)

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "user_login", nullable = false, length = 60)

    public String getUserLogin() {
        return this.userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Column(name = "user_email", nullable = false, length = 100)

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "registered", nullable = false, length = 19)

    public Timestamp getRegistered() {
        return this.registered;
    }

    public void setRegistered(Timestamp registered) {
        this.registered = registered;
    }

    @Column(name = "activated", nullable = false, length = 19)

    public Timestamp getActivated() {
        return this.activated;
    }

    public void setActivated(Timestamp activated) {
        this.activated = activated;
    }

    @Column(name = "active", nullable = false)

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Column(name = "activation_key", nullable = false, length = 50)

    public String getActivationKey() {
        return this.activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    @Column(name = "meta")

    public String getMeta() {
        return this.meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

}
