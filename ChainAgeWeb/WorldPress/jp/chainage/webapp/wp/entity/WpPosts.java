package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * WpPosts entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_posts", schema = "")
public class WpPosts implements java.io.Serializable {
    private static final long serialVersionUID = -1013098998605302084L;

    // Fields
    private Long id;
    private Long postAuthor;
    private Timestamp postDate;
    private Timestamp postDateGmt;
    private String postContent;
    private String postTitle;
    private String postExcerpt;
    private String postStatus;
    private String commentStatus;
    private String pingStatus;
    private String postPassword;
    private String postName;
    private String toPing;
    private String pinged;
    private Timestamp postModified;
    private Timestamp postModifiedGmt;
    private String postContentFiltered;
    private Long postParent;
    private String guid;
    private Integer menuOrder;
    private String postType;
    private String postMimeType;
    private Long commentCount;

    // 附加属性
    private String AuthorName; // 作者名称
    private String categories; // 分类集
    private String postTags; // 标签集
    private String specialPictureUrl; // 特色图片地址

    // Constructors

    /** default constructor */
    public WpPosts() {}

    /** full constructor */
    public WpPosts(Long postAuthor, Timestamp postDate, Timestamp postDateGmt, String postContent, String postTitle, String postExcerpt, String postStatus, String commentStatus,
            String pingStatus, String postPassword, String postName, String toPing, String pinged, Timestamp postModified, Timestamp postModifiedGmt, String postContentFiltered,
            Long postParent, String guid, Integer menuOrder, String postType, String postMimeType, Long commentCount) {
        this.postAuthor = postAuthor;
        this.postDate = postDate;
        this.postDateGmt = postDateGmt;
        this.postContent = postContent;
        this.postTitle = postTitle;
        this.postExcerpt = postExcerpt;
        this.postStatus = postStatus;
        this.commentStatus = commentStatus;
        this.pingStatus = pingStatus;
        this.postPassword = postPassword;
        this.postName = postName;
        this.toPing = toPing;
        this.pinged = pinged;
        this.postModified = postModified;
        this.postModifiedGmt = postModifiedGmt;
        this.postContentFiltered = postContentFiltered;
        this.postParent = postParent;
        this.guid = guid;
        this.menuOrder = menuOrder;
        this.postType = postType;
        this.postMimeType = postMimeType;
        this.commentCount = commentCount;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "post_author", nullable = false)

    public Long getPostAuthor() {
        return this.postAuthor;
    }

    public void setPostAuthor(Long postAuthor) {
        this.postAuthor = postAuthor;
    }

    @Column(name = "post_date", nullable = false, length = 19)

    public Timestamp getPostDate() {
        return this.postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    @Column(name = "post_date_gmt", nullable = false, length = 19)

    public Timestamp getPostDateGmt() {
        return this.postDateGmt;
    }

    public void setPostDateGmt(Timestamp postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    @Column(name = "post_content", nullable = false)

    public String getPostContent() {
        return this.postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    @Column(name = "post_title", nullable = false, length = 65535)

    public String getPostTitle() {
        return this.postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    @Column(name = "post_excerpt", nullable = false, length = 65535)

    public String getPostExcerpt() {
        return this.postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    @Column(name = "post_status", nullable = false, length = 20)

    public String getPostStatus() {
        return this.postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    @Column(name = "comment_status", nullable = false, length = 20)

    public String getCommentStatus() {
        return this.commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Column(name = "ping_status", nullable = false, length = 20)

    public String getPingStatus() {
        return this.pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    @Column(name = "post_password", nullable = false)

    public String getPostPassword() {
        return this.postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    @Column(name = "post_name", nullable = false, length = 200)

    public String getPostName() {
        return this.postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Column(name = "to_ping", nullable = false, length = 65535)

    public String getToPing() {
        return this.toPing;
    }

    public void setToPing(String toPing) {
        this.toPing = toPing;
    }

    @Column(name = "pinged", nullable = false, length = 65535)

    public String getPinged() {
        return this.pinged;
    }

    public void setPinged(String pinged) {
        this.pinged = pinged;
    }

    @Column(name = "post_modified", nullable = false, length = 19)

    public Timestamp getPostModified() {
        return this.postModified;
    }

    public void setPostModified(Timestamp postModified) {
        this.postModified = postModified;
    }

    @Column(name = "post_modified_gmt", nullable = false, length = 19)

    public Timestamp getPostModifiedGmt() {
        return this.postModifiedGmt;
    }

    public void setPostModifiedGmt(Timestamp postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    @Column(name = "post_content_filtered", nullable = false)

    public String getPostContentFiltered() {
        return this.postContentFiltered;
    }

    public void setPostContentFiltered(String postContentFiltered) {
        this.postContentFiltered = postContentFiltered;
    }

    @Column(name = "post_parent", nullable = false)

    public Long getPostParent() {
        return this.postParent;
    }

    public void setPostParent(Long postParent) {
        this.postParent = postParent;
    }

    @Column(name = "guid", nullable = false)

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Column(name = "menu_order", nullable = false)

    public Integer getMenuOrder() {
        return this.menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Column(name = "post_type", nullable = false, length = 20)

    public String getPostType() {
        return this.postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    @Column(name = "post_mime_type", nullable = false, length = 100)

    public String getPostMimeType() {
        return this.postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    @Column(name = "comment_count", nullable = false)

    public Long getCommentCount() {
        return this.commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @Transient
    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    @Transient
    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Transient
    public String getPostTags() {
        return postTags;
    }

    public void setPostTags(String postTags) {
        this.postTags = postTags;
    }

    @Transient
    public String getSpecialPictureUrl() {
        return specialPictureUrl;
    }

    public void setSpecialPictureUrl(String specialPictureUrl) {
        this.specialPictureUrl = specialPictureUrl;
    }

}
