package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpNotificationsMeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_notifications_meta", schema = "")
public class WpBpNotificationsMeta implements java.io.Serializable {
    private static final long serialVersionUID = -5242735278362104093L;

    // Fields  
    private Long id;
    private Long notificationId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpBpNotificationsMeta() {}

    /** minimal constructor */
    public WpBpNotificationsMeta(Long notificationId) {
        this.notificationId = notificationId;
    }

    /** full constructor */
    public WpBpNotificationsMeta(Long notificationId, String metaKey, String metaValue) {
        this.notificationId = notificationId;
        this.metaKey = metaKey;
        this.metaValue = metaValue;
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

    @Column(name = "notification_id", nullable = false)

    public Long getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
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
