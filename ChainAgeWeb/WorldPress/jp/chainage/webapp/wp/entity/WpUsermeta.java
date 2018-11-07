package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpUsermeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_usermeta", schema = "")
public class WpUsermeta implements java.io.Serializable {
    private static final long serialVersionUID = 7492575996673539642L;

    // Fields
    private Long umetaId;
    private Long userId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpUsermeta() {}

    /** minimal constructor */
    public WpUsermeta(Long userId) {
        this.userId = userId;
    }

    /** full constructor */
    public WpUsermeta(Long userId, String metaKey, String metaValue) {
        this.userId = userId;
        this.metaKey = metaKey;
        this.metaValue = metaValue;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "umeta_id", unique = true, nullable = false)

    public Long getUmetaId() {
        return this.umetaId;
    }

    public void setUmetaId(Long umetaId) {
        this.umetaId = umetaId;
    }

    @Column(name = "user_id", nullable = false)

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "meta_key")

    public String getMetaKey() {
        return this.metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    @Column(name = "meta_value")

    public String getMetaValue() {
        return this.metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

}
