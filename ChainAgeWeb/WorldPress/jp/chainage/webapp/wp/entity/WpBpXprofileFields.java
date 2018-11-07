package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpXprofileFields entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_xprofile_fields", schema = "")
public class WpBpXprofileFields implements java.io.Serializable {
    private static final long serialVersionUID = 153646794262911285L;

    // Fields  
    private Long id;
    private Long groupId;
    private Long parentId;
    private String type;
    private String name;
    private String description;
    private Boolean isRequired;
    private Boolean isDefaultOption;
    private Long fieldOrder;
    private Long optionOrder;
    private String orderBy;
    private Boolean canDelete;

    // Constructors

    /** default constructor */
    public WpBpXprofileFields() {}

    /** full constructor */
    public WpBpXprofileFields(Long groupId, Long parentId, String type, String name, String description, Boolean isRequired, Boolean isDefaultOption, Long fieldOrder,
            Long optionOrder, String orderBy, Boolean canDelete) {
        this.groupId = groupId;
        this.parentId = parentId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.isRequired = isRequired;
        this.isDefaultOption = isDefaultOption;
        this.fieldOrder = fieldOrder;
        this.optionOrder = optionOrder;
        this.orderBy = orderBy;
        this.canDelete = canDelete;
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

    @Column(name = "group_id", nullable = false)

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Column(name = "parent_id", nullable = false)

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Column(name = "type", nullable = false, length = 150)

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "name", nullable = false, length = 150)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "is_required", nullable = false)

    public Boolean getIsRequired() {
        return this.isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Column(name = "is_default_option", nullable = false)

    public Boolean getIsDefaultOption() {
        return this.isDefaultOption;
    }

    public void setIsDefaultOption(Boolean isDefaultOption) {
        this.isDefaultOption = isDefaultOption;
    }

    @Column(name = "field_order", nullable = false)

    public Long getFieldOrder() {
        return this.fieldOrder;
    }

    public void setFieldOrder(Long fieldOrder) {
        this.fieldOrder = fieldOrder;
    }

    @Column(name = "option_order", nullable = false)

    public Long getOptionOrder() {
        return this.optionOrder;
    }

    public void setOptionOrder(Long optionOrder) {
        this.optionOrder = optionOrder;
    }

    @Column(name = "order_by", nullable = false, length = 15)

    public String getOrderBy() {
        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Column(name = "can_delete", nullable = false)

    public Boolean getCanDelete() {
        return this.canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

}
