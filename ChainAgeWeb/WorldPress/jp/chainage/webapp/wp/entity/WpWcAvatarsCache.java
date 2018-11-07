package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpWcAvatarsCache entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_wc_avatars_cache", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "user_email"))
public class WpWcAvatarsCache implements java.io.Serializable {
    private static final long serialVersionUID = 3565736914880516948L;

    // Fields
    private Integer id;
    private Integer userId;
    private String userEmail;
    private String url;
    private String hash;
    private Integer maketime;
    private Boolean cached;

    // Constructors

    /** default constructor */
    public WpWcAvatarsCache() {}

    /** full constructor */
    public WpWcAvatarsCache(Integer userId, String userEmail, String url, String hash, Integer maketime, Boolean cached) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.url = url;
        this.hash = hash;
        this.maketime = maketime;
        this.cached = cached;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "user_id", nullable = false)

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "user_email", unique = true, nullable = false)

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "url", nullable = false)

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "hash", nullable = false)

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Column(name = "maketime", nullable = false)

    public Integer getMaketime() {
        return this.maketime;
    }

    public void setMaketime(Integer maketime) {
        this.maketime = maketime;
    }

    @Column(name = "cached", nullable = false)

    public Boolean getCached() {
        return this.cached;
    }

    public void setCached(Boolean cached) {
        this.cached = cached;
    }

}
