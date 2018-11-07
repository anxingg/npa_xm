package jp.chainage.webapp.wp.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WpCpOrders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wp_cp_orders", schema = "")
public class WpCpOrders implements java.io.Serializable {
    private static final long serialVersionUID = -7625853393940243068L;

    // Fields
    private Integer id;
    private String item;
    private String price;
    private String currency;
    private String paymentAddress;
    private String name;
    private String email;
    private String address;
    private String telephone;
    private String description;
    private Timestamp time;

    // Constructors

    /** default constructor */
    public WpCpOrders() {}

    /** minimal constructor */
    public WpCpOrders(String item, String name, String email, Timestamp time) {
        this.item = item;
        this.name = name;
        this.email = email;
        this.time = time;
    }

    /** full constructor */
    public WpCpOrders(String item, String price, String currency, String paymentAddress, String name, String email, String address, String telephone, String description,
            Timestamp time) {
        this.item = item;
        this.price = price;
        this.currency = currency;
        this.paymentAddress = paymentAddress;
        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
        this.description = description;
        this.time = time;
    }

    // Property accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "item", nullable = false, length = 65535)

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Column(name = "price", length = 65535)

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Column(name = "currency", length = 65535)

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Column(name = "payment_address", length = 65535)

    public String getPaymentAddress() {
        return this.paymentAddress;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    @Column(name = "name", nullable = false, length = 65535)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", nullable = false, length = 65535)

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "address", length = 65535)

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "telephone", length = 65535)

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "description", length = 65535)

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "time", nullable = false, length = 19)

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

}
