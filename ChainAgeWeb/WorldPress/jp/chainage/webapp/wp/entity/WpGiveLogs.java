package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpGiveLogs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_give_logs", schema = "")
public class WpGiveLogs implements java.io.Serializable {
    private static final long serialVersionUID = 2150374420211288454L;

    // Fields
    private Long id;
    private String logTitle;
    private String logContent;
    private Long logParent;
    private String logType;
    private Timestamp logDate;
    private Timestamp logDateGmt;

    // Constructors

    /** default constructor */
    public WpGiveLogs() {}

    /** full constructor */
    public WpGiveLogs(String logTitle, String logContent, Long logParent, String logType, Timestamp logDate, Timestamp logDateGmt) {
        this.logTitle = logTitle;
        this.logContent = logContent;
        this.logParent = logParent;
        this.logType = logType;
        this.logDate = logDate;
        this.logDateGmt = logDateGmt;
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

    @Column(name = "log_title", nullable = false)

    public String getLogTitle() {
        return this.logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    @Column(name = "log_content", nullable = false)

    public String getLogContent() {
        return this.logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    @Column(name = "log_parent", nullable = false)

    public Long getLogParent() {
        return this.logParent;
    }

    public void setLogParent(Long logParent) {
        this.logParent = logParent;
    }

    @Column(name = "log_type", nullable = false, length = 16777215)

    public String getLogType() {
        return this.logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    @Column(name = "log_date", nullable = false, length = 19)

    public Timestamp getLogDate() {
        return this.logDate;
    }

    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }

    @Column(name = "log_date_gmt", nullable = false, length = 19)

    public Timestamp getLogDateGmt() {
        return this.logDateGmt;
    }

    public void setLogDateGmt(Timestamp logDateGmt) {
        this.logDateGmt = logDateGmt;
    }

}
