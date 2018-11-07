package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpRevsliderCssId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpRevsliderCssId implements java.io.Serializable {
    private static final long serialVersionUID = 356138409710573380L;

    // Fields
    private Integer id;
    private String handle;
    private String settings;
    private String hover;
    private String advanced;
    private String params;

    // Constructors

    /** default constructor */
    public WpRevsliderCssId() {}

    /** minimal constructor */
    public WpRevsliderCssId(Integer id, String handle, String params) {
        this.id = id;
        this.handle = handle;
        this.params = params;
    }

    /** full constructor */
    public WpRevsliderCssId(Integer id, String handle, String settings, String hover, String advanced, String params) {
        this.id = id;
        this.handle = handle;
        this.settings = settings;
        this.hover = hover;
        this.advanced = advanced;
        this.params = params;
    }

    // Property accessors

    @Column(name = "id", unique = true, nullable = false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "handle", nullable = false, length = 65535)

    public String getHandle() {
        return this.handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Column(name = "settings")

    public String getSettings() {
        return this.settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    @Column(name = "hover")

    public String getHover() {
        return this.hover;
    }

    public void setHover(String hover) {
        this.hover = hover;
    }

    @Column(name = "advanced")

    public String getAdvanced() {
        return this.advanced;
    }

    public void setAdvanced(String advanced) {
        this.advanced = advanced;
    }

    @Column(name = "params", nullable = false)

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WpRevsliderCssId))
            return false;
        WpRevsliderCssId castOther = (WpRevsliderCssId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getHandle() == castOther.getHandle()) || (this.getHandle() != null && castOther.getHandle() != null && this.getHandle().equals(castOther.getHandle())))
                && ((this.getSettings() == castOther.getSettings())
                        || (this.getSettings() != null && castOther.getSettings() != null && this.getSettings().equals(castOther.getSettings())))
                && ((this.getHover() == castOther.getHover()) || (this.getHover() != null && castOther.getHover() != null && this.getHover().equals(castOther.getHover())))
                && ((this.getAdvanced() == castOther.getAdvanced())
                        || (this.getAdvanced() != null && castOther.getAdvanced() != null && this.getAdvanced().equals(castOther.getAdvanced())))
                && ((this.getParams() == castOther.getParams()) || (this.getParams() != null && castOther.getParams() != null && this.getParams().equals(castOther.getParams())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getHandle() == null ? 0 : this.getHandle().hashCode());
        result = 37 * result + (getSettings() == null ? 0 : this.getSettings().hashCode());
        result = 37 * result + (getHover() == null ? 0 : this.getHover().hashCode());
        result = 37 * result + (getAdvanced() == null ? 0 : this.getAdvanced().hashCode());
        result = 37 * result + (getParams() == null ? 0 : this.getParams().hashCode());
        return result;
    }

}
