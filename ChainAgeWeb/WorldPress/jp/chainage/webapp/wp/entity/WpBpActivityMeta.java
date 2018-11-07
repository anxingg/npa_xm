package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpActivityMeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_activity_meta", schema = "")
public class WpBpActivityMeta implements java.io.Serializable {
    private static final long serialVersionUID = -6485282112038853070L;

    // Fields
    private Long id;
    private Long activityId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpBpActivityMeta() {}

    /** minimal constructor */
    public WpBpActivityMeta(Long activityId) {
        this.activityId = activityId;
    }

    /** full constructor */
    public WpBpActivityMeta(Long activityId, String metaKey, String metaValue) {
        this.activityId = activityId;
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

    @Column(name = "activity_id", nullable = false)

    public Long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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
