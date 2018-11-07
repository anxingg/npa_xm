package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpPostmeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_postmeta", schema = "")
public class WpPostmeta implements java.io.Serializable {
    private static final long serialVersionUID = 4334820994650441179L;

    // Fields
    private Long metaId;
    private Long postId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpPostmeta() {}

    /** minimal constructor */
    public WpPostmeta(Long postId) {
        this.postId = postId;
    }

    /** full constructor */
    public WpPostmeta(Long postId, String metaKey, String metaValue) {
        this.postId = postId;
        this.metaKey = metaKey;
        this.metaValue = metaValue;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "meta_id", unique = true, nullable = false)

    public Long getMetaId() {
        return this.metaId;
    }

    public void setMetaId(Long metaId) {
        this.metaId = metaId;
    }

    @Column(name = "post_id", nullable = false)

    public Long getPostId() {
        return this.postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Column(name = "meta_key")

    public String getMetaKey() {
        return this.metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    @Column(name = "meta_value")

    public String getMetaValue() {
        return this.metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

}
