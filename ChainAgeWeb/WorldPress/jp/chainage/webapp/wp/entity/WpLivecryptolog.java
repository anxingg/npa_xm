package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpLivecryptolog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_livecryptolog", schema = "")
public class WpLivecryptolog implements java.io.Serializable {
    private static final long serialVersionUID = -7038963478006630828L;

    // Fields
    private Long id;
    private String ipAddress;
    private Timestamp dateAccepted;

    // Constructors

    /** default constructor */
    public WpLivecryptolog() {}

    /** full constructor */
    public WpLivecryptolog(String ipAddress, Timestamp dateAccepted) {
        this.ipAddress = ipAddress;
        this.dateAccepted = dateAccepted;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ip_address", nullable = false)

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Column(name = "date_accepted", nullable = false, length = 19)

    public Timestamp getDateAccepted() {
        return this.dateAccepted;
    }

    public void setDateAccepted(Timestamp dateAccepted) {
        this.dateAccepted = dateAccepted;
    }

}
