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
@Table(name = "cc_btc_monitor_ohlcv_history", schema = "")
public class CcBtcMonitorOhlcvHistory implements java.io.Serializable {
    private static final long serialVersionUID = -1602664670557271746L;

    // Fields
    private String id;
    private String baseSymbol;
    private String quoteSymbol;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private Date lastUpdated;
    private Date createDate;
    private Date updateDate;

    // Constructors

    /** default constructor */
    public CcBtcMonitorOhlcvHistory() {}

    /** full constructor */
    public CcBtcMonitorOhlcvHistory(String baseSymbol, String quoteSymbol, double open, double high, double low, double close, double volume, Date lastUpdated, Date createDate,
            Date updateDate) {
        this.baseSymbol = baseSymbol;
        this.quoteSymbol = quoteSymbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
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

    @Column(name = "base_symbol", length = 32)
    public String getBaseSymbol() {
        return this.baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    @Column(name = "quote_symbol", length = 32)
    public String getQuoteSymbol() {
        return this.quoteSymbol;
    }

    public void setQuoteSymbol(String quoteSymbol) {
        this.quoteSymbol = quoteSymbol;
    }

    @Column(name = "open", precision = 22, scale = 0)
    public double getOpen() {
        return this.open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    @Column(name = "high", precision = 22, scale = 0)
    public double getHigh() {
        return this.high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Column(name = "low", precision = 22, scale = 0)
    public double getLow() {
        return this.low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    @Column(name = "close", precision = 22, scale = 0)
    public double getClose() {
        return this.close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    @Column(name = "volume", precision = 22, scale = 0)
    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
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
