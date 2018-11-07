package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpActivity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_activity", schema = "")
public class WpBpActivity implements java.io.Serializable {
    private static final long serialVersionUID = -4735497924469321256L;

    // Fields
    private Long id;
    private Long userId;
    private String component;
    private String type;
    private String action;
    private String content;
    private String primaryLink;
    private Long itemId;
    private Long secondaryItemId;
    private Timestamp dateRecorded;
    private Boolean hideSitewide;
    private Integer mpttLeft;
    private Integer mpttRight;
    private Boolean isSpam;

    // Constructors

    /** default constructor */
    public WpBpActivity() {}

    /** minimal constructor */
    public WpBpActivity(Long userId, String component, String type, String action, String content, String primaryLink, Long itemId, Timestamp dateRecorded, Integer mpttLeft,
            Integer mpttRight, Boolean isSpam) {
        this.userId = userId;
        this.component = component;
        this.type = type;
        this.action = action;
        this.content = content;
        this.primaryLink = primaryLink;
        this.itemId = itemId;
        this.dateRecorded = dateRecorded;
        this.mpttLeft = mpttLeft;
        this.mpttRight = mpttRight;
        this.isSpam = isSpam;
    }

    /** full constructor */
    public WpBpActivity(Long userId, String component, String type, String action, String content, String primaryLink, Long itemId, Long secondaryItemId, Timestamp dateRecorded,
            Boolean hideSitewide, Integer mpttLeft, Integer mpttRight, Boolean isSpam) {
        this.userId = userId;
        this.component = component;
        this.type = type;
        this.action = action;
        this.content = content;
        this.primaryLink = primaryLink;
        this.itemId = itemId;
        this.secondaryItemId = secondaryItemId;
        this.dateRecorded = dateRecorded;
        this.hideSitewide = hideSitewide;
        this.mpttLeft = mpttLeft;
        this.mpttRight = mpttRight;
        this.isSpam = isSpam;
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

    @Column(name = "component", nullable = false, length = 75)

    public String getComponent() {
        return this.component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Column(name = "type", nullable = false, length = 75)

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "action", nullable = false, length = 65535)

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Column(name = "content", nullable = false)

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "primary_link", nullable = false, length = 65535)

    public String getPrimaryLink() {
        return this.primaryLink;
    }

    public void setPrimaryLink(String primaryLink) {
        this.primaryLink = primaryLink;
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

    @Column(name = "date_recorded", nullable = false, length = 19)

    public Timestamp getDateRecorded() {
        return this.dateRecorded;
    }

    public void setDateRecorded(Timestamp dateRecorded) {
        this.dateRecorded = dateRecorded;
    }

    @Column(name = "hide_sitewide")

    public Boolean getHideSitewide() {
        return this.hideSitewide;
    }

    public void setHideSitewide(Boolean hideSitewide) {
        this.hideSitewide = hideSitewide;
    }

    @Column(name = "mptt_left", nullable = false)

    public Integer getMpttLeft() {
        return this.mpttLeft;
    }

    public void setMpttLeft(Integer mpttLeft) {
        this.mpttLeft = mpttLeft;
    }

    @Column(name = "mptt_right", nullable = false)

    public Integer getMpttRight() {
        return this.mpttRight;
    }

    public void setMpttRight(Integer mpttRight) {
        this.mpttRight = mpttRight;
    }

    @Column(name = "is_spam", nullable = false)

    public Boolean getIsSpam() {
        return this.isSpam;
    }

    public void setIsSpam(Boolean isSpam) {
        this.isSpam = isSpam;
    }

}
