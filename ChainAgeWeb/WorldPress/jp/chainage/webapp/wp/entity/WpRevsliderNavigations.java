package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpRevsliderNavigations entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_revslider_navigations", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class WpRevsliderNavigations implements java.io.Serializable {
    private static final long serialVersionUID = -8662171372199555351L;

    // Fields
    private WpRevsliderNavigationsId id;

    // Constructors

    /** default constructor */
    public WpRevsliderNavigations() {}

    /** full constructor */
    public WpRevsliderNavigations(WpRevsliderNavigationsId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 191)),
            @AttributeOverride(name = "handle", column = @Column(name = "handle", nullable = false, length = 191)),
            @AttributeOverride(name = "css", column = @Column(name = "css", nullable = false)),
            @AttributeOverride(name = "markup", column = @Column(name = "markup", nullable = false)), @AttributeOverride(name = "settings", column = @Column(name = "settings"))})

    public WpRevsliderNavigationsId getId() {
        return this.id;
    }

    public void setId(WpRevsliderNavigationsId id) {
        this.id = id;
    }

}
