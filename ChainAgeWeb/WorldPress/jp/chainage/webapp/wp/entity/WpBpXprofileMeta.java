package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpXprofileMeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_xprofile_meta", schema = "")
public class WpBpXprofileMeta implements java.io.Serializable {
    private static final long serialVersionUID = 5818746791484708895L;

    // Fields
    private Long id;
    private Long objectId;
    private String objectType;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpBpXprofileMeta() {}

    /** minimal constructor */
    public WpBpXprofileMeta(Long objectId, String objectType) {
        this.objectId = objectId;
        this.objectType = objectType;
    }

    /** full constructor */
    public WpBpXprofileMeta(Long objectId, String objectType, String metaKey, String metaValue) {
        this.objectId = objectId;
        this.objectType = objectType;
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

    @Column(name = "object_id", nullable = false)

    public Long getObjectId() {
        return this.objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    @Column(name = "object_type", nullable = false, length = 150)

    public String getObjectType() {
        return this.objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
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
