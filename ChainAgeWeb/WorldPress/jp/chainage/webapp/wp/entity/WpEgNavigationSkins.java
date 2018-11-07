package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpEgNavigationSkins entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_eg_navigation_skins", schema = "", uniqueConstraints = {@UniqueConstraint(columnNames = "handle"), @UniqueConstraint(columnNames = "id")})
public class WpEgNavigationSkins implements java.io.Serializable {
    private static final long serialVersionUID = 6425506557616875553L;

    // Fields   
    private WpEgNavigationSkinsId id;

    // Constructors

    /** default constructor */
    public WpEgNavigationSkins() {}

    /** full constructor */
    public WpEgNavigationSkins(WpEgNavigationSkinsId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 191)),
            @AttributeOverride(name = "handle", column = @Column(name = "handle", unique = true, nullable = false, length = 191)),
            @AttributeOverride(name = "css", column = @Column(name = "css", nullable = false, length = 16777215))})

    public WpEgNavigationSkinsId getId() {
        return this.id;
    }

    public void setId(WpEgNavigationSkinsId id) {
        this.id = id;
    }

}
