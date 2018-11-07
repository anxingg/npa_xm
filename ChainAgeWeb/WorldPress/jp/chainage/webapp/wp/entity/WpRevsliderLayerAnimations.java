package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpRevsliderLayerAnimations entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_revslider_layer_animations", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class WpRevsliderLayerAnimations implements java.io.Serializable {
    private static final long serialVersionUID = -2160952679117904498L;

    // Fields
    private WpRevsliderLayerAnimationsId id;

    // Constructors

    /** default constructor */
    public WpRevsliderLayerAnimations() {}

    /** full constructor */
    public WpRevsliderLayerAnimations(WpRevsliderLayerAnimationsId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "handle", column = @Column(name = "handle", nullable = false, length = 65535)),
            @AttributeOverride(name = "params", column = @Column(name = "params", nullable = false, length = 65535)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings", length = 65535))})

    public WpRevsliderLayerAnimationsId getId() {
        return this.id;
    }

    public void setId(WpRevsliderLayerAnimationsId id) {
        this.id = id;
    }

}
