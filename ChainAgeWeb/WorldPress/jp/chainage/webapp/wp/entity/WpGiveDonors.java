package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpGiveDonors entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_give_donors", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class WpGiveDonors implements java.io.Serializable {
    private static final long serialVersionUID = 8965743781712522406L;

    // Fields
    private Long id;
    private Long userId;
    private String email;
    private String name;
    private String purchaseValue;
    private Long purchaseCount;
    private String paymentIds;
    private String notes;
    private Timestamp dateCreated;
    private String token;
    private String verifyKey;
    private Timestamp verifyThrottle;

    // Constructors

    /** default constructor */
    public WpGiveDonors() {}

    /** full constructor */
    public WpGiveDonors(Long userId, String email, String name, String purchaseValue, Long purchaseCount, String paymentIds, String notes, Timestamp dateCreated, String token,
            String verifyKey, Timestamp verifyThrottle) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.purchaseValue = purchaseValue;
        this.purchaseCount = purchaseCount;
        this.paymentIds = paymentIds;
        this.notes = notes;
        this.dateCreated = dateCreated;
        this.token = token;
        this.verifyKey = verifyKey;
        this.verifyThrottle = verifyThrottle;
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

    @Column(name = "user_id", nullable = false)

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "email", unique = true, nullable = false, length = 50)

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "name", nullable = false, length = 16777215)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "purchase_value", nullable = false, length = 16777215)

    public String getPurchaseValue() {
        return this.purchaseValue;
    }

    public void setPurchaseValue(String purchaseValue) {
        this.purchaseValue = purchaseValue;
    }

    @Column(name = "purchase_count", nullable = false)

    public Long getPurchaseCount() {
        return this.purchaseCount;
    }

    public void setPurchaseCount(Long purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    @Column(name = "payment_ids", nullable = false)

    public String getPaymentIds() {
        return this.paymentIds;
    }

    public void setPaymentIds(String paymentIds) {
        this.paymentIds = paymentIds;
    }

    @Column(name = "notes", nullable = false)

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(name = "date_created", nullable = false, length = 19)

    public Timestamp getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "token", nullable = false)

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "verify_key", nullable = false)

    public String getVerifyKey() {
        return this.verifyKey;
    }

    public void setVerifyKey(String verifyKey) {
        this.verifyKey = verifyKey;
    }

    @Column(name = "verify_throttle", nullable = false, length = 19)

    public Timestamp getVerifyThrottle() {
        return this.verifyThrottle;
    }

    public void setVerifyThrottle(Timestamp verifyThrottle) {
        this.verifyThrottle = verifyThrottle;
    }

}
