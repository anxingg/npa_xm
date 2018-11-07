package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpRevsliderStaticSlidesId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpRevsliderStaticSlidesId implements java.io.Serializable {
    private static final long serialVersionUID = -3876430312544934066L;

    // Fields
    private Integer id;
    private Integer sliderId;
    private String params;
    private String layers;
    private String settings;

    // Constructors

    /** default constructor */
    public WpRevsliderStaticSlidesId() {}

    /** full constructor */
    public WpRevsliderStaticSlidesId(Integer id, Integer sliderId, String params, String layers, String settings) {
        this.id = id;
        this.sliderId = sliderId;
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

    @Column(name = "slider_id", nullable = false)

    public Integer getSliderId() {
        return this.sliderId;
    }

    public void setSliderId(Integer sliderId) {
        this.sliderId = sliderId;
    }

    @Column(name = "params", nullable = false)

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Column(name = "layers", nullable = false)

    public String getLayers() {
        return this.layers;
    }

    public void setLayers(String layers) {
        this.layers = layers;
    }

    @Column(name = "settings", nullable = false, length = 65535)

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
        if (!(other instanceof WpRevsliderStaticSlidesId))
            return false;
        WpRevsliderStaticSlidesId castOther = (WpRevsliderStaticSlidesId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getSliderId() == castOther.getSliderId())
                        || (this.getSliderId() != null && castOther.getSliderId() != null && this.getSliderId().equals(castOther.getSliderId())))
                && ((this.getParams() == castOther.getParams()) || (this.getParams() != null && castOther.getParams() != null && this.getParams().equals(castOther.getParams())))
                && ((this.getLayers() == castOther.getLayers()) || (this.getLayers() != null && castOther.getLayers() != null && this.getLayers().equals(castOther.getLayers())))
                && ((this.getSettings() == castOther.getSettings())
                        || (this.getSettings() != null && castOther.getSettings() != null && this.getSettings().equals(castOther.getSettings())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getSliderId() == null ? 0 : this.getSliderId().hashCode());
        result = 37 * result + (getParams() == null ? 0 : this.getParams().hashCode());
        result = 37 * result + (getLayers() == null ? 0 : this.getLayers().hashCode());
        result = 37 * result + (getSettings() == null ? 0 : this.getSettings().hashCode());
        return result;
    }

}
