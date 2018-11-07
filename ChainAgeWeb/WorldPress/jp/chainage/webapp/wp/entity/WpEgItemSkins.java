package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpEgItemSkins entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_eg_item_skins", schema = "",
        uniqueConstraints = {@UniqueConstraint(columnNames = "name"), @UniqueConstraint(columnNames = "handle"), @UniqueConstraint(columnNames = "id")})
public class WpEgItemSkins implements java.io.Serializable {
    private static final long serialVersionUID = -5658840980327084912L;

    // Fields
    private WpEgItemSkinsId id;

    // Constructors

    /** default constructor */
    public WpEgItemSkins() {}

    /** full constructor */
    public WpEgItemSkins(WpEgItemSkinsId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "name", column = @Column(name = "name", unique = true, nullable = false, length = 191)),
            @AttributeOverride(name = "handle", column = @Column(name = "handle", unique = true, nullable = false, length = 191)),
            @AttributeOverride(name = "params", column = @Column(name = "params", nullable = false, length = 65535)),
            @AttributeOverride(name = "layers", column = @Column(name = "layers", nullable = false, length = 16777215)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings", length = 65535))})

    public WpEgItemSkinsId getId() {
        return this.id;
    }

    public void setId(WpEgItemSkinsId id) {
        this.id = id;
    }

}
