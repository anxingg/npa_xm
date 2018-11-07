package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpGivePaymentmeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_give_paymentmeta", schema = "")
public class WpGivePaymentmeta implements java.io.Serializable {
    private static final long serialVersionUID = -1103108147838268694L;

    // Fields
    private Long metaId;
    private Long paymentId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpGivePaymentmeta() {}

    /** minimal constructor */
    public WpGivePaymentmeta(Long paymentId) {
        this.paymentId = paymentId;
    }

    /** full constructor */
    public WpGivePaymentmeta(Long paymentId, String metaKey, String metaValue) {
        this.paymentId = paymentId;
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

    @Column(name = "payment_id", nullable = false)

    public Long getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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
