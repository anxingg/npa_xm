package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpCommentmeta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_commentmeta", schema = "")
public class WpCommentmeta implements java.io.Serializable {
    private static final long serialVersionUID = -4014485285155051404L;

    // Fields
    private Long metaId;
    private Long commentId;
    private String metaKey;
    private String metaValue;

    // Constructors

    /** default constructor */
    public WpCommentmeta() {}

    /** minimal constructor */
    public WpCommentmeta(Long commentId) {
        this.commentId = commentId;
    }

    /** full constructor */
    public WpCommentmeta(Long commentId, String metaKey, String metaValue) {
        this.commentId = commentId;
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

    @Column(name = "comment_id", nullable = false)

    public Long getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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
