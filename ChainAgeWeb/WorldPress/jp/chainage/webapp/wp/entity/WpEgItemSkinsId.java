package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpEgItemSkinsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpEgItemSkinsId implements java.io.Serializable {
    private static final long serialVersionUID = 2416433971669222064L;

    // Fields
    private Integer id;
    private String name;
    private String handle;
    private String params;
    private String layers;
    private String settings;

    // Constructors

    /** default constructor */
    public WpEgItemSkinsId() {}

    /** minimal constructor */
    public WpEgItemSkinsId(Integer id, String name, String handle, String params, String layers) {
        this.id = id;
        this.name = name;
        this.handle = handle;
        this.params = params;
        this.layers = layers;
    }

    /** full constructor */
    public WpEgItemSkinsId(Integer id, String name, String handle, String params, String layers, String settings) {
        this.id = id;
        this.name = name;
        this.handle = handle;
        this.params = params;
        this.layers = layers;
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

    @Column(name = "name", unique = true, nullable = false, length = 191)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "handle", unique = true, nullable = false, length = 191)

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

    @Column(name = "layers", nullable = false, length = 16777215)

    public String getLayers() {
        return this.layers;
    }

    public void setLayers(String layers) {
        this.layers = layers;
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
        if (!(other instanceof WpEgItemSkinsId))
            return false;
        WpEgItemSkinsId castOther = (WpEgItemSkinsId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(castOther.getName())))
                && ((this.getHandle() == castOther.getHandle()) || (this.getHandle() != null && castOther.getHandle() != null && this.getHandle().equals(castOther.getHandle())))
                && ((this.getParams() == castOther.getParams()) || (this.getParams() != null && castOther.getParams() != null && this.getParams().equals(castOther.getParams())))
                && ((this.getLayers() == castOther.getLayers()) || (this.getLayers() != null && castOther.getLayers() != null && this.getLayers().equals(castOther.getLayers())))
                && ((this.getSettings() == castOther.getSettings())
                        || (this.getSettings() != null && castOther.getSettings() != null && this.getSettings().equals(castOther.getSettings())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
        result = 37 * result + (getHandle() == null ? 0 : this.getHandle().hashCode());
        result = 37 * result + (getParams() == null ? 0 : this.getParams().hashCode());
        result = 37 * result + (getLayers() == null ? 0 : this.getLayers().hashCode());
        result = 37 * result + (getSettings() == null ? 0 : this.getSettings().hashCode());
        return result;
    }

}
