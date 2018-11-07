package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpRevsliderStaticSlides entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_revslider_static_slides", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class WpRevsliderStaticSlides implements java.io.Serializable {
    private static final long serialVersionUID = -4850415909028202108L;
    private WpRevsliderStaticSlidesId id;

    // Constructors

    /** default constructor */
    public WpRevsliderStaticSlides() {}

    /** full constructor */
    public WpRevsliderStaticSlides(WpRevsliderStaticSlidesId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "sliderId", column = @Column(name = "slider_id", nullable = false)),
            @AttributeOverride(name = "params", column = @Column(name = "params", nullable = false)),
            @AttributeOverride(name = "layers", column = @Column(name = "layers", nullable = false)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings", nullable = false, length = 65535))})

    public WpRevsliderStaticSlidesId getId() {
        return this.id;
    }

    public void setId(WpRevsliderStaticSlidesId id) {
        this.id = id;
    }

}
