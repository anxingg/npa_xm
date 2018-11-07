package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpEgItemElements entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_eg_item_elements", schema = "", uniqueConstraints = {@UniqueConstraint(columnNames = "handle"), @UniqueConstraint(columnNames = "id")})
public class WpEgItemElements implements java.io.Serializable {
    private static final long serialVersionUID = -6221556971203705352L;

    // Fields
    private WpEgItemElementsId id;

    // Constructors

    /** default constructor */
    public WpEgItemElements() {}

    /** full constructor */
    public WpEgItemElements(WpEgItemElementsId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 191)),
            @AttributeOverride(name = "handle", column = @Column(name = "handle", unique = true, nullable = false, length = 191)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings", nullable = false, length = 16777215))})

    public WpEgItemElementsId getId() {
        return this.id;
    }

    public void setId(WpEgItemElementsId id) {
        this.id = id;
    }

}
