package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpBpXprofileGroups entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_bp_xprofile_groups", schema = "")
public class WpBpXprofileGroups implements java.io.Serializable {
    private static final long serialVersionUID = 4048254075378284808L;

    // Fields
    private Long id;
    private String name;
    private String description;
    private Long groupOrder;
    private Boolean canDelete;

    // Constructors

    /** default constructor */
    public WpBpXprofileGroups() {}

    /** full constructor */
    public WpBpXprofileGroups(String name, String description, Long groupOrder, Boolean canDelete) {
        this.name = name;
        this.description = description;
        this.groupOrder = groupOrder;
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

    @Column(name = "name", nullable = false, length = 150)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false, length = 16777215)

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "group_order", nullable = false)

    public Long getGroupOrder() {
        return this.groupOrder;
    }

    public void setGroupOrder(Long groupOrder) {
        this.groupOrder = groupOrder;
    }

    @Column(name = "can_delete", nullable = false)

    public Boolean getCanDelete() {
        return this.canDelete;
    }

    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

}
