package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpRevsliderLayerAnimationsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpRevsliderLayerAnimationsId implements java.io.Serializable {
    private static final long serialVersionUID = -6871914129479233157L;

    // Fields
    private Integer id;
    private String handle;
    private String params;
    private String settings;

    // Constructors

    /** default constructor */
    public WpRevsliderLayerAnimationsId() {}

    /** minimal constructor */
    public WpRevsliderLayerAnimationsId(Integer id, String handle, String params) {
        this.id = id;
        this.handle = handle;
        this.params = params;
    }

    /** full constructor */
    public WpRevsliderLayerAnimationsId(Integer id, String handle, String params, String settings) {
        this.id = id;
        this.handle = handle;
        this.params = params;
        this.settings = settings;
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

    @Column(name = "params", nullable = false, length = 65535)

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

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WpRevsliderLayerAnimationsId))
            return false;
        WpRevsliderLayerAnimationsId castOther = (WpRevsliderLayerAnimationsId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getHandle() == castOther.getHandle()) || (this.getHandle() != null && castOther.getHandle() != null && this.getHandle().equals(castOther.getHandle())))
                && ((this.getParams() == castOther.getParams()) || (this.getParams() != null && castOther.getParams() != null && this.getParams().equals(castOther.getParams())))
                && ((this.getSettings() == castOther.getSettings())
                        || (this.getSettings() != null && castOther.getSettings() != null && this.getSettings().equals(castOther.getSettings())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getHandle() == null ? 0 : this.getHandle().hashCode());
        result = 37 * result + (getParams() == null ? 0 : this.getParams().hashCode());
        result = 37 * result + (getSettings() == null ? 0 : this.getSettings().hashCode());
        return result;
    }

}
