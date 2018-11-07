package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpRevsliderNavigationsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpRevsliderNavigationsId implements java.io.Serializable {
    private static final long serialVersionUID = 3037029682658129089L;

    // Fields
    private Integer id;
    private String name;
    private String handle;
    private String css;
    private String markup;
    private String settings;

    // Constructors

    /** default constructor */
    public WpRevsliderNavigationsId() {}

    /** minimal constructor */
    public WpRevsliderNavigationsId(Integer id, String name, String handle, String css, String markup) {
        this.id = id;
        this.name = name;
        this.handle = handle;
        this.css = css;
        this.markup = markup;
    }

    /** full constructor */
    public WpRevsliderNavigationsId(Integer id, String name, String handle, String css, String markup, String settings) {
        this.id = id;
        this.name = name;
        this.handle = handle;
        this.css = css;
        this.markup = markup;
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

    @Column(name = "name", nullable = false, length = 191)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "handle", nullable = false, length = 191)

    public String getHandle() {
        return this.handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Column(name = "css", nullable = false)

    public String getCss() {
        return this.css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    @Column(name = "markup", nullable = false)

    public String getMarkup() {
        return this.markup;
    }

    public void setMarkup(String markup) {
        this.markup = markup;
    }

    @Column(name = "settings")

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
        if (!(other instanceof WpRevsliderNavigationsId))
            return false;
        WpRevsliderNavigationsId castOther = (WpRevsliderNavigationsId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(castOther.getName())))
                && ((this.getHandle() == castOther.getHandle()) || (this.getHandle() != null && castOther.getHandle() != null && this.getHandle().equals(castOther.getHandle())))
                && ((this.getCss() == castOther.getCss()) || (this.getCss() != null && castOther.getCss() != null && this.getCss().equals(castOther.getCss())))
                && ((this.getMarkup() == castOther.getMarkup()) || (this.getMarkup() != null && castOther.getMarkup() != null && this.getMarkup().equals(castOther.getMarkup())))
                && ((this.getSettings() == castOther.getSettings())
                        || (this.getSettings() != null && castOther.getSettings() != null && this.getSettings().equals(castOther.getSettings())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
        result = 37 * result + (getHandle() == null ? 0 : this.getHandle().hashCode());
        result = 37 * result + (getCss() == null ? 0 : this.getCss().hashCode());
        result = 37 * result + (getMarkup() == null ? 0 : this.getMarkup().hashCode());
        result = 37 * result + (getSettings() == null ? 0 : this.getSettings().hashCode());
        return result;
    }

}
