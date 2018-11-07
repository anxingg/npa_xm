package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpGiveDonormeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_give_donormeta", schema = "")
public class WpGiveDonormeta implements java.io.Serializable {
    private static final long serialVersionUID = -3311065380224607953L;

    // Fields
    private Long metaId;
    private Long donorId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpGiveDonormeta() {}

    /** minimal constructor */
    public WpGiveDonormeta(Long donorId) {
        this.donorId = donorId;
    }

    /** full constructor */
    public WpGiveDonormeta(Long donorId, String metaKey, String metaValue) {
        this.donorId = donorId;
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

    @Column(name = "donor_id", nullable = false)

    public Long getDonorId() {
        return this.donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
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
