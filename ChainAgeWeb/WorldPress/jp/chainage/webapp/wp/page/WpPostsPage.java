package jp.chainage.webapp.wp.page;

import java.sql.Timestamp;

public class WpPostsPage {
    private Long id; // 文章主键
    private String postTitle; // 文章标题
    private String postContent; // 文章内容
    private Long postAuthor; // 作者主键
    private Long commentCount; // 评论数
    private Timestamp postDate; // 发布时间
    private Timestamp postModified; // 最后编辑时间
    private String authorName; // 作者名称
    private String specialPictureUrl; // 特色图片地址
    private String categories; // 分类集
    private String postTags; // 标签集
    private int readingTime; // 需要阅读的时间

    public WpPostsPage() {}

    public WpPostsPage(Long id, String postTitle, String postContent, Long postAuthor, Long commentCount, Timestamp postModified, String authorName, String specialPictureUrl) {
        super();
        this.id = id;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postAuthor = postAuthor;
        this.commentCount = commentCount;
        this.postModified = postModified;
        this.authorName = authorName;
        this.specialPictureUrl = specialPictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Long getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Long postAuthor) {
        this.postAuthor = postAuthor;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public Timestamp getPostModified() {
        return postModified;
    }

    public void setPostModified(Timestamp postModified) {
        this.postModified = postModified;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSpecialPictureUrl() {
        return specialPictureUrl;
    }

    public void setSpecialPictureUrl(String specialPictureUrl) {
        this.specialPictureUrl = specialPictureUrl;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getPostTags() {
        return postTags;
    }

    public void setPostTags(String postTags) {
        this.postTags = postTags;
    }

    public int getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(int readingTime) {
        this.readingTime = readingTime;
    }
}
