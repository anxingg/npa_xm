package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpTerms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_terms", schema = "")
public class WpTerms implements java.io.Serializable {
    private static final long serialVersionUID = -9197902702563910053L;

    // Fields
    private Long termId;
    private String name;
    private String slug;
    private Long termGroup;

    // Constructors

    /** default constructor */
    public WpTerms() {}

    /** full constructor */
    public WpTerms(String name, String slug, Long termGroup) {
        this.name = name;
        this.slug = slug;
        this.termGroup = termGroup;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "term_id", unique = true, nullable = false)

    public Long getTermId() {
        return this.termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    @Column(name = "name", nullable = false, length = 200)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "slug", nullable = false, length = 200)

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Column(name = "term_group", nullable = false)

    public Long getTermGroup() {
        return this.termGroup;
    }

    public void setTermGroup(Long termGroup) {
        this.termGroup = termGroup;
    }

}
