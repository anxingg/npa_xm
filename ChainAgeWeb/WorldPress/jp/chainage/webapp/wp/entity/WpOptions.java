package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * WpOptions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_options", schema = "", uniqueConstraints = @UniqueConstraint(columnNames = "option_name"))
public class WpOptions implements java.io.Serializable {
    private static final long serialVersionUID = 2547908046219724830L;

    // Fields
    private Long optionId;
    private String optionName;
    private String optionValue;
    private String autoload;

    // Constructors

    /** default constructor */
    public WpOptions() {}

    /** full constructor */
    public WpOptions(String optionName, String optionValue, String autoload) {
        this.optionName = optionName;
        this.optionValue = optionValue;
        this.autoload = autoload;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "option_id", unique = true, nullable = false)

    public Long getOptionId() {
        return this.optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    @Column(name = "option_name", unique = true, nullable = false, length = 191)

    public String getOptionName() {
        return this.optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    @Column(name = "option_value", nullable = false)

    public String getOptionValue() {
        return this.optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    @Column(name = "autoload", nullable = false, length = 20)

    public String getAutoload() {
        return this.autoload;
    }

    public void setAutoload(String autoload) {
        this.autoload = autoload;
    }

}
