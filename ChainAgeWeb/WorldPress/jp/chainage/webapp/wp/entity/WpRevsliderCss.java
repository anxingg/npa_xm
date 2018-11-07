package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpRevsliderCss entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_revslider_css", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class WpRevsliderCss implements java.io.Serializable {
    private static final long serialVersionUID = 4502960912236251580L;

    // Fields
    private WpRevsliderCssId id;

    // Constructors

    /** default constructor */
    public WpRevsliderCss() {}

    /** full constructor */
    public WpRevsliderCss(WpRevsliderCssId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "handle", column = @Column(name = "handle", nullable = false, length = 65535)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings")), @AttributeOverride(name = "hover", column = @Column(name = "hover")),
            @AttributeOverride(name = "advanced", column = @Column(name = "advanced")), @AttributeOverride(name = "params", column = @Column(name = "params", nullable = false))})

    public WpRevsliderCssId getId() {
        return this.id;
    }

    public void setId(WpRevsliderCssId id) {
        this.id = id;
    }

}
