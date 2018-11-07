package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpXprofileData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_xprofile_data", schema = "")
public class WpBpXprofileData implements java.io.Serializable {
    private static final long serialVersionUID = -2401175221067045791L;

    // Fields  
    private Long id;
    private Long fieldId;
    private Long userId;
    private String value;
    private Timestamp lastUpdated;

    // Constructors

    /** default constructor */
    public WpBpXprofileData() {}

    /** full constructor */
    public WpBpXprofileData(Long fieldId, Long userId, String value, Timestamp lastUpdated) {
        this.fieldId = fieldId;
        this.userId = userId;
        this.value = value;
        this.lastUpdated = lastUpdated;
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

    @Column(name = "field_id", nullable = false)

    public Long getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    @Column(name = "user_id", nullable = false)

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "value", nullable = false)

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "last_updated", nullable = false, length = 19)

    public Timestamp getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
