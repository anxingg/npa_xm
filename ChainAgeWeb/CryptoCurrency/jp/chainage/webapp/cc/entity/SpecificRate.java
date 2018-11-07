package jp.chainage.webapp.cc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cc_specific_rate", schema = "")
public class SpecificRate implements java.io.Serializable {
    private static final long serialVersionUID = -8609479767302235417L;

    // Fields
    private String id;
    private int baseId;
    private String baseSymbol;
    private String baseName;
    private String quoteSymbol;
    private double price;
    private double volume24h;
    private double percentChange1h;
    private double percentChange24h;
    private double percentChange7d;
    private double marketCap;
    private Date lastUpdated;
    private Date createDate;
    private Date updateDate;

    // Constructors

    /** default constructor */
    public SpecificRate() {}

    /** full constructor */
    public SpecificRate(int baseId, String baseSymbol, String baseName, String quoteSymbol, double price, double volume24h, double percentChange1h, double percentChange24h,
            double percentChange7d, double marketCap, Date lastUpdated, Date createDate, Date updateDate) {
        this.baseId = baseId;
        this.baseSymbol = baseSymbol;
        this.baseName = baseName;
        this.quoteSymbol = quoteSymbol;
        this.price = price;
        this.volume24h = volume24h;
        this.percentChange1h = percentChange1h;
        this.percentChange24h = percentChange24h;
        this.percentChange7d = percentChange7d;
        this.marketCap = marketCap;
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

    @Column(name = "base_id")
    public Integer getBaseId() {
        return this.baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    @Column(name = "base_symbol", length = 32)
    public String getBaseSymbol() {
        return this.baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    @Column(name = "base_name", length = 32)
    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    @Column(name = "quote_symbol", length = 32)
    public String getQuoteSymbol() {
        return this.quoteSymbol;
    }

    public void setQuoteSymbol(String quoteSymbol) {
        this.quoteSymbol = quoteSymbol;
    }

    @Column(name = "price", precision = 22, scale = 0)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "volume_24h", precision = 22, scale = 0)
    public double getVolume24h() {
        return this.volume24h;
    }

    public void setVolume24h(double volume24h) {
        this.volume24h = volume24h;
    }

    @Column(name = "percent_change_1h", precision = 22, scale = 0)
    public double getPercentChange1h() {
        return this.percentChange1h;
    }

    public void setPercentChange1h(double percentChange1h) {
        this.percentChange1h = percentChange1h;
    }

    @Column(name = "percent_change_24h", precision = 22, scale = 0)
    public double getPercentChange24h() {
        return this.percentChange24h;
    }

    public void setPercentChange24h(double percentChange24h) {
        this.percentChange24h = percentChange24h;
    }

    @Column(name = "percent_change_7d", precision = 22, scale = 0)
    public double getPercentChange7d() {
        return this.percentChange7d;
    }

    public void setPercentChange7d(double percentChange7d) {
        this.percentChange7d = percentChange7d;
    }

    @Column(name = "market_cap", precision = 22, scale = 0)
    public double getMarketCap() {
        return this.marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
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
