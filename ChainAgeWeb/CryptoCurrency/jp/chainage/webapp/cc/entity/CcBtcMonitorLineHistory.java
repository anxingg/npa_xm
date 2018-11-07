package jp.chainage.webapp.cc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * BTC监视器固定OHLCV历史
 */
@Entity
@Table(name = "cc_btc_monitor_line_history", schema = "")
public class CcBtcMonitorLineHistory implements java.io.Serializable {
    private static final long serialVersionUID = 5109831202489159489L;

    // Fields
    private String id;
    private String baseSymbol;
    private double priceJpy;
    private double priceUsd;
    private double priceEur;
    private double priceCny;
    private Date lastUpdated;
    private Date createDate;
    private Date updateDate;

    // Constructors

    /** default constructor */
    public CcBtcMonitorLineHistory() {}

    /** full constructor */
    public CcBtcMonitorLineHistory(String baseSymbol, double priceJpy, double priceUsd, double priceEur, double priceCny, Date lastUpdated, Date createDate, Date updateDate) {
        this.baseSymbol = baseSymbol;
        this.priceJpy = priceJpy;
        this.priceUsd = priceUsd;
        this.priceEur = priceEur;
        this.priceCny = priceCny;
        this.lastUpdated = lastUpdated;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    // Property accessors
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "base_symbol")
    public String getBaseSymbol() {
        return this.baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    @Column(name = "price_jpy", precision = 22, scale = 0)
    public double getPriceJpy() {
        return priceJpy;
    }

    public void setPriceJpy(double priceJpy) {
        this.priceJpy = priceJpy;
    }

    @Column(name = "price_usd", precision = 22, scale = 0)
    public double getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    @Column(name = "price_eur", precision = 22, scale = 0)
    public double getPriceEur() {
        return priceEur;
    }

    public void setPriceEur(double priceEur) {
        this.priceEur = priceEur;
    }

    @Column(name = "price_cny", precision = 22, scale = 0)
    public double getPriceCny() {
        return priceCny;
    }

    public void setPriceCny(double priceCny) {
        this.priceCny = priceCny;
    }

    @Column(name = "last_updated", length = 19)
    public Date getLastUpdated() {
        return this.lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Column(name = "create_date", length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "update_date", length = 19)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
