package jp.chainage.webapp.wp.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WpEgNavigationSkinsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class WpEgNavigationSkinsId implements java.io.Serializable {
    private static final long serialVersionUID = -8260737628930998374L;

    // Fields
    private Integer id;
    private String name;
    private String handle;
    private String css;

    // Constructors

    /** default constructor */
    public WpEgNavigationSkinsId() {}

    /** full constructor */
    public WpEgNavigationSkinsId(Integer id, String name, String handle, String css) {
        this.id = id;
        this.name = name;
        this.handle = handle;
        this.css = css;
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

    @Column(name = "css", nullable = false, length = 16777215)

    public String getCss() {
        return this.css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof WpEgNavigationSkinsId))
            return false;
        WpEgNavigationSkinsId castOther = (WpEgNavigationSkinsId) other;

        return ((this.getId() == castOther.getId()) || (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())))
                && ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(castOther.getName())))
                && ((this.getHandle() == castOther.getHandle()) || (this.getHandle() != null && castOther.getHandle() != null && this.getHandle().equals(castOther.getHandle())))
                && ((this.getCss() == castOther.getCss()) || (this.getCss() != null && castOther.getCss() != null && this.getCss().equals(castOther.getCss())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
        result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
        result = 37 * result + (getHandle() == null ? 0 : this.getHandle().hashCode());
        result = 37 * result + (getCss() == null ? 0 : this.getCss().hashCode());
        return result;
    }

}
