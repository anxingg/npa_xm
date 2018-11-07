package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpGiveLogmeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_give_logmeta", schema = "")
public class WpGiveLogmeta implements java.io.Serializable {
    private static final long serialVersionUID = 8990305854188363837L;

    // Fields
    private Long metaId;
    private Long logId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpGiveLogmeta() {}

    /** minimal constructor */
    public WpGiveLogmeta(Long logId) {
        this.logId = logId;
    }

    /** full constructor */
    public WpGiveLogmeta(Long logId, String metaKey, String metaValue) {
        this.logId = logId;
        this.metaKey = metaKey;
        this.metaValue = metaValue;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "meta_id", unique = true, nullable = false)

    public Long getMetaId() {
        return this.metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    @Column(name = "log_id", nullable = false)

    public Long getLogId() {
        return this.logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
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
