package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpEgGrids entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_eg_grids", schema = "", uniqueConstraints = {@UniqueConstraint(columnNames = "handle"), @UniqueConstraint(columnNames = "id")})
public class WpEgGrids implements java.io.Serializable {
    private static final long serialVersionUID = -357393084782054043L;

    // Fields
    private WpEgGridsId id;

    // Constructors

    /** default constructor */
    public WpEgGrids() {}

    /** full constructor */
    public WpEgGrids(WpEgGridsId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 191)),
            @AttributeOverride(name = "handle", column = @Column(name = "handle", unique = true, nullable = false, length = 191)),
            @AttributeOverride(name = "postparams", column = @Column(name = "postparams", nullable = false, length = 65535)),
            @AttributeOverride(name = "params", column = @Column(name = "params", nullable = false, length = 65535)),
            @AttributeOverride(name = "layers", column = @Column(name = "layers", nullable = false, length = 16777215)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings", length = 65535)),
            @AttributeOverride(name = "lastModified", column = @Column(name = "last_modified", length = 19))})

    public WpEgGridsId getId() {
        return this.id;
    }

    public void setId(WpEgGridsId id) {
        this.id = id;
    }

}
