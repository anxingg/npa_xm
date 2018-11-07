package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpTermTaxonomy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_term_taxonomy", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = {"term_id", "taxonomy"}))
public class WpTermTaxonomy implements java.io.Serializable {
    private static final long serialVersionUID = -266598017514259142L;

    // Fields
    private Long termTaxonomyId;
    private Long termId;
    private String taxonomy;
    private String description;
    private Long parent;
    private Long count;

    // Constructors

    /** default constructor */
    public WpTermTaxonomy() {}

    /** full constructor */
    public WpTermTaxonomy(Long termId, String taxonomy, String description, Long parent, Long count) {
        this.termId = termId;
        this.taxonomy = taxonomy;
        this.description = description;
        this.parent = parent;
        this.count = count;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "term_taxonomy_id", unique = true, nullable = false)

    public Long getTermTaxonomyId() {
        return this.termTaxonomyId;
    }

    public void setTermTaxonomyId(Long termTaxonomyId) {
        this.termTaxonomyId = termTaxonomyId;
    }

    @Column(name = "term_id", nullable = false)

    public Long getTermId() {
        return this.termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    @Column(name = "taxonomy", nullable = false, length = 32)

    public String getTaxonomy() {
        return this.taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    @Column(name = "description", nullable = false)

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "parent", nullable = false)

    public Long getParent() {
        return this.parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    @Column(name = "count", nullable = false)

    public Long getCount() {
        return this.count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
