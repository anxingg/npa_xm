package jp.chainage.webapp.cc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 交易所交易资产
 * 
 * @author zhaoqi
 *
 */
@Entity
@Table(name = "cc_float_exchange", schema = "")
public class FloatExchange implements java.io.Serializable {
    private static final long serialVersionUID = 2156667907816454592L;
    private String id;
    private int exchangeId;
    private String name;
    private String slug;
    private int numMarketPairs;
    private double volume24hUnitA;
    private double volume24hUnitB;
    private Date lastUpdated;
    private Date createDate;
    private Date updateDate;

    // Constructors

    /** default constructor */
    public FloatExchange() {}

    /** full constructor */
    public FloatExchange(int exchangeId, String name, String slug, int numMarketPairs, double volume24hUnitA, double volume24hUnitB, Date lastUpdated, Date createDate,
            Date updateDate) {
        this.exchangeId = exchangeId;
        this.name = name;
        this.slug = slug;
        this.numMarketPairs = numMarketPairs;
        this.volume24hUnitA = volume24hUnitA;
        this.volume24hUnitB = volume24hUnitB;
        this.lastUpdated = lastUpdated;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    // Property accessors
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "exchange_id", nullable = false)
    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "slug", nullable = false)
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Column(name = "num_market_pairs", nullable = false)
    public int getNumMarketPairs() {
        return numMarketPairs;
    }

    public void setNumMarketPairs(int numMarketPairs) {
        this.numMarketPairs = numMarketPairs;
    }

    @Column(name = "b_volume_24h", nullable = false)
    public double getVolume24hUnitA() {
        return volume24hUnitA;
    }

    public void setVolume24hUnitA(double volume24hUnitA) {
        this.volume24hUnitA = volume24hUnitA;
    }

    @Column(name = "q_volume_24h", nullable = false)
    public double getVolume24hUnitB() {
        return volume24hUnitB;
    }

    public void setVolume24hUnitB(double volume24hUnitB) {
        this.volume24hUnitB = volume24hUnitB;
    }

    @Column(name = "last_updated", nullable = false)
    public Date getLastUpdated() {
        return lastUpdated;
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
