package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpGiveFormmeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_give_formmeta", schema = "")
public class WpGiveFormmeta implements java.io.Serializable {
    private static final long serialVersionUID = -1221695615362593340L;

    // Fields
    private Long metaId;
    private Long formId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpGiveFormmeta() {}

    /** minimal constructor */
    public WpGiveFormmeta(Long formId) {
        this.formId = formId;
    }

    /** full constructor */
    public WpGiveFormmeta(Long formId, String metaKey, String metaValue) {
        this.formId = formId;
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

    @Column(name = "form_id", nullable = false)

    public Long getFormId() {
        return this.formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
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
