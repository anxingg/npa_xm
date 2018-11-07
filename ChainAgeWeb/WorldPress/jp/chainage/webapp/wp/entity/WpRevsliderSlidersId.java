package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpRevsliderSlidersId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpRevsliderSlidersId implements java.io.Serializable {
    private static final long serialVersionUID = -132201163108763491L;

    // Fields
    private Integer id;
    private String title;
    private String alias;
    private String params;
    private String settings;
    private String type;

    // Constructors

    /** default constructor */
    public WpRevsliderSlidersId() {}

    /** minimal constructor */
    public WpRevsliderSlidersId(Integer id, String title, String params, String type) {
        this.id = id;
        this.title = title;
        this.params = params;
        this.type = type;
    }

    /** full constructor */
    public WpRevsliderSlidersId(Integer id, String title, String alias, String params, String settings, String type) {
        this.id = id;
        this.title = title;
        this.alias = alias;
        this.params = params;
        this.settings = settings;
        this.type = type;
    }

    // Property accessors

    @Column(name = "id", unique = true, nullable = false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "alias")

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Column(name = "params", nullable = false)

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Column(name = "settings", length = 65535)

    public String getSettings() {
        return this.settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    @Column(name = "type", nullable = false, length = 191)

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WpRevsliderSlidersId))
            return false;
        WpRevsliderSlidersId castOther = (WpRevsliderSlidersId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getTitle() == castOther.getTitle()) || (this.getTitle() != null && castOther.getTitle() != null && this.getTitle().equals(castOther.getTitle())))
                && ((this.getAlias() == castOther.getAlias()) || (this.getAlias() != null && castOther.getAlias() != null && this.getAlias().equals(castOther.getAlias())))
                && ((this.getParams() == castOther.getParams()) || (this.getParams() != null && castOther.getParams() != null && this.getParams().equals(castOther.getParams())))
                && ((this.getSettings() == castOther.getSettings())
                        || (this.getSettings() != null && castOther.getSettings() != null && this.getSettings().equals(castOther.getSettings())))
                && ((this.getType() == castOther.getType()) || (this.getType() != null && castOther.getType() != null && this.getType().equals(castOther.getType())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getTitle() == null ? 0 : this.getTitle().hashCode());
        result = 37 * result + (getAlias() == null ? 0 : this.getAlias().hashCode());
        result = 37 * result + (getParams() == null ? 0 : this.getParams().hashCode());
        result = 37 * result + (getSettings() == null ? 0 : this.getSettings().hashCode());
        result = 37 * result + (getType() == null ? 0 : this.getType().hashCode());
        return result;
    }

}
