package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpGiveSequentialOrdering entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_give_sequential_ordering", schema = "")
public class WpGiveSequentialOrdering implements java.io.Serializable {
    private static final long serialVersionUID = -7445411466700630354L;

    // Fields
    private Long id;
    private Long paymentId;

    // Constructors

    /** default constructor */
    public WpGiveSequentialOrdering() {}

    /** full constructor */
    public WpGiveSequentialOrdering(Long paymentId) {
        this.paymentId = paymentId;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "payment_id", nullable = false)

    public Long getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

}
