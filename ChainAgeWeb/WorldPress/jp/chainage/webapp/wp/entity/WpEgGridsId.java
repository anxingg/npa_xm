package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpEgGridsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpEgGridsId implements java.io.Serializable {
    private static final long serialVersionUID = 7891000417353577152L;

    // Fields
    private Integer id;
    private String name;
    private String handle;
    private String postparams;
    private String params;
    private String layers;
    private String settings;
    private Timestamp lastModified;

    // Constructors

    /** default constructor */
    public WpEgGridsId() {}

    /** minimal constructor */
    public WpEgGridsId(Integer id, String name, String handle, String postparams, String params, String layers) {
        this.id = id;
        this.name = name;
        this.handle = handle;
        this.postparams = postparams;
        this.params = params;
        this.layers = layers;
    }

    /** full constructor */
    public WpEgGridsId(Integer id, String name, String handle, String postparams, String params, String layers, String settings, Timestamp lastModified) {
        this.id = id;
        this.name = name;
        this.handle = handle;
        this.postparams = postparams;
        this.params = params;
        this.layers = layers;
        this.settings = settings;
        this.lastModified = lastModified;
    }

    // Property accessors

    @Column(name = "id", unique = true, nullable = false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 191)

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

    @Column(name = "postparams", nullable = false, length = 65535)

    public String getPostparams() {
        return this.postparams;
    }

    public void setPostparams(String postparams) {
        this.postparams = postparams;
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

    @Column(name = "last_modified", length = 19)

    public Timestamp getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WpEgGridsId))
            return false;
        WpEgGridsId castOther = (WpEgGridsId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(castOther.getName())))
                && ((this.getHandle() == castOther.getHandle()) || (this.getHandle() != null && castOther.getHandle() != null && this.getHandle().equals(castOther.getHandle())))
                && ((this.getPostparams() == castOther.getPostparams())
                        || (this.getPostparams() != null && castOther.getPostparams() != null && this.getPostparams().equals(castOther.getPostparams())))
                && ((this.getParams() == castOther.getParams()) || (this.getParams() != null && castOther.getParams() != null && this.getParams().equals(castOther.getParams())))
                && ((this.getLayers() == castOther.getLayers()) || (this.getLayers() != null && castOther.getLayers() != null && this.getLayers().equals(castOther.getLayers())))
                && ((this.getSettings() == castOther.getSettings())
                        || (this.getSettings() != null && castOther.getSettings() != null && this.getSettings().equals(castOther.getSettings())))
                && ((this.getLastModified() == castOther.getLastModified())
                        || (this.getLastModified() != null && castOther.getLastModified() != null && this.getLastModified().equals(castOther.getLastModified())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
        result = 37 * result + (getHandle() == null ? 0 : this.getHandle().hashCode());
        result = 37 * result + (getPostparams() == null ? 0 : this.getPostparams().hashCode());
        result = 37 * result + (getParams() == null ? 0 : this.getParams().hashCode());
        result = 37 * result + (getLayers() == null ? 0 : this.getLayers().hashCode());
        result = 37 * result + (getSettings() == null ? 0 : this.getSettings().hashCode());
        result = 37 * result + (getLastModified() == null ? 0 : this.getLastModified().hashCode());
        return result;
    }

}
