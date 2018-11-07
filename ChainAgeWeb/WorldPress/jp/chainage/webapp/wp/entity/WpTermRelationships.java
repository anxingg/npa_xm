package jp.chainage.webapp.wp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * WpTermRelationships entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_term_relationships", schema = "")
public class WpTermRelationships implements java.io.Serializable {
    private static final long serialVersionUID = -69398594818868703L;

    // Fields
    private WpTermRelationshipsId id;
    private Integer termOrder;

    // Constructors

    /** default constructor */
    public WpTermRelationships() {}

    /** full constructor */
    public WpTermRelationships(WpTermRelationshipsId id, Integer termOrder) {
        this.id = id;
        this.termOrder = termOrder;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "objectId", column = @Column(name = "object_id", nullable = false)),
            @AttributeOverride(name = "termTaxonomyId", column = @Column(name = "term_taxonomy_id", nullable = false))})

    public WpTermRelationshipsId getId() {
        return this.id;
    }

    public void setId(WpTermRelationshipsId id) {
        this.id = id;
    }

    @Column(name = "term_order", nullable = false)

    public Integer getTermOrder() {
        return this.termOrder;
    }

    public void setTermOrder(Integer termOrder) {
        this.termOrder = termOrder;
    }

}
