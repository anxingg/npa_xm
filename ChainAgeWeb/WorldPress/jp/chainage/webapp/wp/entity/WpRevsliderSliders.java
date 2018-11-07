package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpRevsliderSliders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_revslider_sliders", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class WpRevsliderSliders implements java.io.Serializable {
    private static final long serialVersionUID = 1684205542540609365L;

    // Fields
    private WpRevsliderSlidersId id;

    // Constructors

    /** default constructor */
    public WpRevsliderSliders() {}

    /** full constructor */
    public WpRevsliderSliders(WpRevsliderSlidersId id) {
        this.id = id;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false)),
            @AttributeOverride(name = "title", column = @Column(name = "title", nullable = false)), @AttributeOverride(name = "alias", column = @Column(name = "alias")),
            @AttributeOverride(name = "params", column = @Column(name = "params", nullable = false)),
            @AttributeOverride(name = "settings", column = @Column(name = "settings", length = 65535)),
            @AttributeOverride(name = "type", column = @Column(name = "type", nullable = false, length = 191))})

    public WpRevsliderSlidersId getId() {
        return this.id;
    }

    public void setId(WpRevsliderSlidersId id) {
        this.id = id;
    }

}
