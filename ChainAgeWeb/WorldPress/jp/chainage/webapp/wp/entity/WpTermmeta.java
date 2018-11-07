package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpTermmeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_termmeta", schema = "")
public class WpTermmeta implements java.io.Serializable {
    private static final long serialVersionUID = -1355797387380364883L;

    // Fields
    private Long metaId;
    private Long termId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpTermmeta() {}

    /** minimal constructor */
    public WpTermmeta(Long termId) {
        this.termId = termId;
    }

    /** full constructor */
    public WpTermmeta(Long termId, String metaKey, String metaValue) {
        this.termId = termId;
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

    @Column(name = "term_id", nullable = false)

    public Long getTermId() {
        return this.termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
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
