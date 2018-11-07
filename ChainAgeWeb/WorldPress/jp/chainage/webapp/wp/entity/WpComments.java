package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpComments entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_comments", schema = "")
public class WpComments implements java.io.Serializable {
    private static final long serialVersionUID = 8100439561720750579L;

    // Fields
    private Long commentId;
    private Long commentPostId;
    private String commentAuthor;
    private String commentAuthorEmail;
    private String commentAuthorUrl;
    private String commentAuthorIp;
    private Timestamp commentDate;
    private Timestamp commentDateGmt;
    private String commentContent;
    private Integer commentKarma;
    private String commentApproved;
    private String commentAgent;
    private String commentType;
    private Long commentParent;
    private Long userId;

    // Constructors

    /** default constructor */
    public WpComments() {}

    /** full constructor */
    public WpComments(Long commentPostId, String commentAuthor, String commentAuthorEmail, String commentAuthorUrl, String commentAuthorIp, Timestamp commentDate,
            Timestamp commentDateGmt, String commentContent, Integer commentKarma, String commentApproved, String commentAgent, String commentType, Long commentParent,
            Long userId) {
        this.commentPostId = commentPostId;
        this.commentAuthor = commentAuthor;
        this.commentAuthorEmail = commentAuthorEmail;
        this.commentAuthorUrl = commentAuthorUrl;
        this.commentAuthorIp = commentAuthorIp;
        this.commentDate = commentDate;
        this.commentDateGmt = commentDateGmt;
        this.commentContent = commentContent;
        this.commentKarma = commentKarma;
        this.commentApproved = commentApproved;
        this.commentAgent = commentAgent;
        this.commentType = commentType;
        this.commentParent = commentParent;
        this.userId = userId;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "comment_ID", unique = true, nullable = false)

    public Long getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Column(name = "comment_post_ID", nullable = false)

    public Long getCommentPostId() {
        return this.commentPostId;
    }

    public void setCommentPostId(Long commentPostId) {
        this.commentPostId = commentPostId;
    }

    @Column(name = "comment_author", nullable = false)

    public String getCommentAuthor() {
        return this.commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    @Column(name = "comment_author_email", nullable = false, length = 100)

    public String getCommentAuthorEmail() {
        return this.commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    @Column(name = "comment_author_url", nullable = false, length = 200)

    public String getCommentAuthorUrl() {
        return this.commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    @Column(name = "comment_author_IP", nullable = false, length = 100)

    public String getCommentAuthorIp() {
        return this.commentAuthorIp;
    }

    public void setCommentAuthorIp(String commentAuthorIp) {
        this.commentAuthorIp = commentAuthorIp;
    }

    @Column(name = "comment_date", nullable = false, length = 19)

    public Timestamp getCommentDate() {
        return this.commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    @Column(name = "comment_date_gmt", nullable = false, length = 19)

    public Timestamp getCommentDateGmt() {
        return this.commentDateGmt;
    }

    public void setCommentDateGmt(Timestamp commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    @Column(name = "comment_content", nullable = false, length = 65535)

    public String getCommentContent() {
        return this.commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Column(name = "comment_karma", nullable = false)

    public Integer getCommentKarma() {
        return this.commentKarma;
    }

    public void setCommentKarma(Integer commentKarma) {
        this.commentKarma = commentKarma;
    }

    @Column(name = "comment_approved", nullable = false, length = 20)

    public String getCommentApproved() {
        return this.commentApproved;
    }

    public void setCommentApproved(String commentApproved) {
        this.commentApproved = commentApproved;
    }

    @Column(name = "comment_agent", nullable = false)

    public String getCommentAgent() {
        return this.commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    @Column(name = "comment_type", nullable = false, length = 20)

    public String getCommentType() {
        return this.commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    @Column(name = "comment_parent", nullable = false)

    public Long getCommentParent() {
        return this.commentParent;
    }

    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    @Column(name = "user_id", nullable = false)

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
