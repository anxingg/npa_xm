package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpNotifications entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_notifications", schema = "")
public class WpBpNotifications implements java.io.Serializable {
    private static final long serialVersionUID = 2482876870114610799L;

    // Fields
    private Long id;
    private Long userId;
    private Long itemId;
    private Long secondaryItemId;
    private String componentName;
    private String componentAction;
    private Timestamp dateNotified;
    private Boolean isNew;

    // Constructors

    /** default constructor */
    public WpBpNotifications() {}

    /** minimal constructor */
    public WpBpNotifications(Long userId, Long itemId, String componentName, String componentAction, Timestamp dateNotified, Boolean isNew) {
        this.userId = userId;
        this.itemId = itemId;
        this.componentName = componentName;
        this.componentAction = componentAction;
        this.dateNotified = dateNotified;
        this.isNew = isNew;
    }

    /** full constructor */
    public WpBpNotifications(Long userId, Long itemId, Long secondaryItemId, String componentName, String componentAction, Timestamp dateNotified, Boolean isNew) {
        this.userId = userId;
        this.itemId = itemId;
        this.secondaryItemId = secondaryItemId;
        this.componentName = componentName;
        this.componentAction = componentAction;
        this.dateNotified = dateNotified;
        this.isNew = isNew;
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

    @Column(name = "item_id", nullable = false)

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(name = "secondary_item_id")

    public Long getSecondaryItemId() {
        return this.secondaryItemId;
    }

    public void setSecondaryItemId(Long secondaryItemId) {
        this.secondaryItemId = secondaryItemId;
    }

    @Column(name = "component_name", nullable = false, length = 75)

    public String getComponentName() {
        return this.componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    @Column(name = "component_action", nullable = false, length = 75)

    public String getComponentAction() {
        return this.componentAction;
    }

    public void setComponentAction(String componentAction) {
        this.componentAction = componentAction;
    }

    @Column(name = "date_notified", nullable = false, length = 19)

    public Timestamp getDateNotified() {
        return this.dateNotified;
    }

    public void setDateNotified(Timestamp dateNotified) {
        this.dateNotified = dateNotified;
    }

    @Column(name = "is_new", nullable = false)

    public Boolean getIsNew() {
        return this.isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

}
