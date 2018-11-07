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
 * WpWcCommentsSubscription entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_wc_comments_subscription", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = {"subscribtion_id", "email", "post_id"}))
public class WpWcCommentsSubscription implements java.io.Serializable {
    private static final long serialVersionUID = 6874956286673981998L;

    // Fields
    private Integer id;
    private String email;
    private Integer subscribtionId;
    private Integer postId;
    private String subscribtionType;
    private String activationKey;
    private Short confirm;
    private Timestamp subscriptionDate;

    // Constructors

    /** default constructor */
    public WpWcCommentsSubscription() {}

    /** minimal constructor */
    public WpWcCommentsSubscription(String email, Integer subscribtionId, Integer postId, String subscribtionType, String activationKey, Timestamp subscriptionDate) {
        this.email = email;
        this.subscribtionId = subscribtionId;
        this.postId = postId;
        this.subscribtionType = subscribtionType;
        this.activationKey = activationKey;
        this.subscriptionDate = subscriptionDate;
    }

    /** full constructor */
    public WpWcCommentsSubscription(String email, Integer subscribtionId, Integer postId, String subscribtionType, String activationKey, Short confirm,
            Timestamp subscriptionDate) {
        this.email = email;
        this.subscribtionId = subscribtionId;
        this.postId = postId;
        this.subscribtionType = subscribtionType;
        this.activationKey = activationKey;
        this.confirm = confirm;
        this.subscriptionDate = subscriptionDate;
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

    @Column(name = "email", nullable = false)

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "subscribtion_id", nullable = false)

    public Integer getSubscribtionId() {
        return this.subscribtionId;
    }

    public void setSubscribtionId(Integer subscribtionId) {
        this.subscribtionId = subscribtionId;
    }

    @Column(name = "post_id", nullable = false)

    public Integer getPostId() {
        return this.postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Column(name = "subscribtion_type", nullable = false)

    public String getSubscribtionType() {
        return this.subscribtionType;
    }

    public void setSubscribtionType(String subscribtionType) {
        this.subscribtionType = subscribtionType;
    }

    @Column(name = "activation_key", nullable = false)

    public String getActivationKey() {
        return this.activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    @Column(name = "confirm")

    public Short getConfirm() {
        return this.confirm;
    }

    public void setConfirm(Short confirm) {
        this.confirm = confirm;
    }

    @Column(name = "subscription_date", nullable = false, length = 19)

    public Timestamp getSubscriptionDate() {
        return this.subscriptionDate;
    }

    public void setSubscriptionDate(Timestamp subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
