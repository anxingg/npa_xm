package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpRevsliderSlides entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_revslider_slides", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class WpRevsliderSlides implements java.io.Serializable {
    private static final long serialVersionUID = -707854708929419393L;

    // Fields
    private WpRevsliderSlidesId id;

    // Constructors

    /** default constructor */
    public WpRevsliderSlides() {}

    /** full constructor */
    public WpRevsliderSlides(WpRevsliderSlidesId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "sliderId", column = @Column(name = "slider_id", nullable = false)),
            @AttributeOverride(name = "slideOrder", column = @Column(name = "slide_order", nullable = false)),
            @AttributeOverride(name = "params", column = @Column(name = "params", nullable = false)),
            @AttributeOverride(name = "layers", column = @Column(name = "layers", nullable = false)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings", nullable = false, length = 65535))})

    public WpRevsliderSlidesId getId() {
        return this.id;
    }

    public void setId(WpRevsliderSlidesId id) {
        this.id = id;
    }

}
