package jp.chainage.webapp.cc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * BTC监视器固定法币费率历史
 */
@Entity
@Table(name = "cc_btc_monitor_rate_history", catalog = "")

public class CcBtcMonitorRateHistory implements java.io.Serializable {
    private static final long serialVersionUID = -5551628870548831794L;

    // Fields
    private String id;
    private String baseSymbol;
    private double priceAud;
    private double priceBrl;
    private double priceGbp;
    private double priceCad;
    private double priceClp;
    private double priceCny;
    private double priceCzk;
    private double priceDkk;
    private double priceEur;
    private double priceHkd;
    private double priceHuf;
    private double priceInr;
    private double priceIdr;
    private double priceIls;
    private double priceJpy;
    private double priceMyr;
    private double priceMxn;
    private double priceTwd;
    private double priceNzd;
    private double priceNok;
    private double pricePkr;
    private double pricePhp;
    private double pricePln;
    private double priceRub;
    private double priceSgd;
    private double priceZar;
    private double priceKrw;
    private double priceSek;
    private double priceChf;
    private double priceThb;
    private double priceTry;
    private double priceUsd;
    private double volume24hUsd;
    private double percentChange1hUsd;
    private double percentChange24hUsd;
    private double percentChange7dUsd;
    private double marketCapUsd;
    private Date lastUpdated;
    private Date createDate;
    private Date updateDate;

    // Constructors

    /** default constructor */
    public CcBtcMonitorRateHistory() {}

    /** full constructor */
    public CcBtcMonitorRateHistory(String baseSymbol, double priceAud, double priceBrl, double priceGbp, double priceCad, double priceClp, double priceCny, double priceCzk,
            double priceDkk, double priceEur, double priceHkd, double priceHuf, double priceInr, double priceIdr, double priceIls, double priceJpy, double priceMyr,
            double priceMxn, double priceTwd, double priceNzd, double priceNok, double pricePkr, double pricePhp, double pricePln, double priceRub, double priceSgd,
            double priceZar, double priceKrw, double priceSek, double priceChf, double priceThb, double priceTry, double priceUsd, double volume24hUsd, double percentChange1hUsd,
            double percentChange24hUsd, double percentChange7dUsd, double marketCapUsd, Date lastUpdated, Date createDate, Date updateDate) {
        this.baseSymbol = baseSymbol;
        this.priceAud = priceAud;
        this.priceBrl = priceBrl;
        this.priceGbp = priceGbp;
        this.priceCad = priceCad;
        this.priceClp = priceClp;
        this.priceCny = priceCny;
        this.priceCzk = priceCzk;
        this.priceDkk = priceDkk;
        this.priceEur = priceEur;
        this.priceHkd = priceHkd;
        this.priceHuf = priceHuf;
        this.priceInr = priceInr;
        this.priceIdr = priceIdr;
        this.priceIls = priceIls;
        this.priceJpy = priceJpy;
        this.priceMyr = priceMyr;
        this.priceMxn = priceMxn;
        this.priceTwd = priceTwd;
        this.priceNzd = priceNzd;
        this.priceNok = priceNok;
        this.pricePkr = pricePkr;
        this.pricePhp = pricePhp;
        this.pricePln = pricePln;
        this.priceRub = priceRub;
        this.priceSgd = priceSgd;
        this.priceZar = priceZar;
        this.priceKrw = priceKrw;
        this.priceSek = priceSek;
        this.priceChf = priceChf;
        this.priceThb = priceThb;
        this.priceTry = priceTry;
        this.priceUsd = priceUsd;
        this.volume24hUsd = volume24hUsd;
        this.percentChange1hUsd = percentChange1hUsd;
        this.percentChange24hUsd = percentChange24hUsd;
        this.percentChange7dUsd = percentChange7dUsd;
        this.marketCapUsd = marketCapUsd;
        this.lastUpdated = lastUpdated;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    // Property accessors
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 32)
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

    @Column(name = "price_aud", precision = 22, scale = 0)
    public double getPriceAud() {
        return this.priceAud;
    }

    public void setPriceAud(double priceAud) {
        this.priceAud = priceAud;
    }

    @Column(name = "price_brl", precision = 22, scale = 0)
    public double getPriceBrl() {
        return this.priceBrl;
    }

    public void setPriceBrl(double priceBrl) {
        this.priceBrl = priceBrl;
    }

    @Column(name = "price_gbp", precision = 22, scale = 0)
    public double getPriceGbp() {
        return this.priceGbp;
    }

    public void setPriceGbp(double priceGbp) {
        this.priceGbp = priceGbp;
    }

    @Column(name = "price_cad", precision = 22, scale = 0)
    public double getPriceCad() {
        return this.priceCad;
    }

    public void setPriceCad(double priceCad) {
        this.priceCad = priceCad;
    }

    @Column(name = "price_clp", precision = 22, scale = 0)
    public double getPriceClp() {
        return this.priceClp;
    }

    public void setPriceClp(double priceClp) {
        this.priceClp = priceClp;
    }

    @Column(name = "price_cny", precision = 22, scale = 0)
    public double getPriceCny() {
        return this.priceCny;
    }

    public void setPriceCny(double priceCny) {
        this.priceCny = priceCny;
    }

    @Column(name = "price_czk", precision = 22, scale = 0)
    public double getPriceCzk() {
        return this.priceCzk;
    }

    public void setPriceCzk(double priceCzk) {
        this.priceCzk = priceCzk;
    }

    @Column(name = "price_dkk", precision = 22, scale = 0)
    public double getPriceDkk() {
        return this.priceDkk;
    }

    public void setPriceDkk(double priceDkk) {
        this.priceDkk = priceDkk;
    }

    @Column(name = "price_eur", precision = 22, scale = 0)
    public double getPriceEur() {
        return this.priceEur;
    }

    public void setPriceEur(double priceEur) {
        this.priceEur = priceEur;
    }

    @Column(name = "price_hkd", precision = 22, scale = 0)
    public double getPriceHkd() {
        return this.priceHkd;
    }

    public void setPriceHkd(double priceHkd) {
        this.priceHkd = priceHkd;
    }

    @Column(name = "price_huf", precision = 22, scale = 0)
    public double getPriceHuf() {
        return this.priceHuf;
    }

    public void setPriceHuf(double priceHuf) {
        this.priceHuf = priceHuf;
    }

    @Column(name = "price_inr", precision = 22, scale = 0)
    public double getPriceInr() {
        return this.priceInr;
    }

    public void setPriceInr(double priceInr) {
        this.priceInr = priceInr;
    }

    @Column(name = "price_idr", precision = 22, scale = 0)
    public double getPriceIdr() {
        return this.priceIdr;
    }

    public void setPriceIdr(double priceIdr) {
        this.priceIdr = priceIdr;
    }

    @Column(name = "price_ils", precision = 22, scale = 0)
    public double getPriceIls() {
        return this.priceIls;
    }

    public void setPriceIls(double priceIls) {
        this.priceIls = priceIls;
    }

    @Column(name = "price_jpy", precision = 22, scale = 0)
    public double getPriceJpy() {
        return this.priceJpy;
    }

    public void setPriceJpy(double priceJpy) {
        this.priceJpy = priceJpy;
    }

    @Column(name = "price_myr", precision = 22, scale = 0)
    public double getPriceMyr() {
        return this.priceMyr;
    }

    public void setPriceMyr(double priceMyr) {
        this.priceMyr = priceMyr;
    }

    @Column(name = "price_mxn", precision = 22, scale = 0)
    public double getPriceMxn() {
        return this.priceMxn;
    }

    public void setPriceMxn(double priceMxn) {
        this.priceMxn = priceMxn;
    }

    @Column(name = "price_twd", precision = 22, scale = 0)
    public double getPriceTwd() {
        return this.priceTwd;
    }

    public void setPriceTwd(double priceTwd) {
        this.priceTwd = priceTwd;
    }

    @Column(name = "price_nzd", precision = 22, scale = 0)
    public double getPriceNzd() {
        return this.priceNzd;
    }

    public void setPriceNzd(double priceNzd) {
        this.priceNzd = priceNzd;
    }

    @Column(name = "price_nok", precision = 22, scale = 0)
    public double getPriceNok() {
        return this.priceNok;
    }

    public void setPriceNok(double priceNok) {
        this.priceNok = priceNok;
    }

    @Column(name = "price_pkr", precision = 22, scale = 0)
    public double getPricePkr() {
        return this.pricePkr;
    }

    public void setPricePkr(double pricePkr) {
        this.pricePkr = pricePkr;
    }

    @Column(name = "price_php", precision = 22, scale = 0)
    public double getPricePhp() {
        return this.pricePhp;
    }

    public void setPricePhp(double pricePhp) {
        this.pricePhp = pricePhp;
    }

    @Column(name = "price_pln", precision = 22, scale = 0)
    public double getPricePln() {
        return this.pricePln;
    }

    public void setPricePln(double pricePln) {
        this.pricePln = pricePln;
    }

    @Column(name = "price_rub", precision = 22, scale = 0)
    public double getPriceRub() {
        return this.priceRub;
    }

    public void setPriceRub(double priceRub) {
        this.priceRub = priceRub;
    }

    @Column(name = "price_sgd", precision = 22, scale = 0)
    public double getPriceSgd() {
        return this.priceSgd;
    }

    public void setPriceSgd(double priceSgd) {
        this.priceSgd = priceSgd;
    }

    @Column(name = "price_zar", precision = 22, scale = 0)
    public double getPriceZar() {
        return this.priceZar;
    }

    public void setPriceZar(double priceZar) {
        this.priceZar = priceZar;
    }

    @Column(name = "price_krw", precision = 22, scale = 0)
    public double getPriceKrw() {
        return this.priceKrw;
    }

    public void setPriceKrw(double priceKrw) {
        this.priceKrw = priceKrw;
    }

    @Column(name = "price_sek", precision = 22, scale = 0)
    public double getPriceSek() {
        return this.priceSek;
    }

    public void setPriceSek(double priceSek) {
        this.priceSek = priceSek;
    }

    @Column(name = "price_chf", precision = 22, scale = 0)
    public double getPriceChf() {
        return this.priceChf;
    }

    public void setPriceChf(double priceChf) {
        this.priceChf = priceChf;
    }

    @Column(name = "price_thb", precision = 22, scale = 0)
    public double getPriceThb() {
        return this.priceThb;
    }

    public void setPriceThb(double priceThb) {
        this.priceThb = priceThb;
    }

    @Column(name = "price_try", precision = 22, scale = 0)
    public double getPriceTry() {
        return this.priceTry;
    }

    public void setPriceTry(double priceTry) {
        this.priceTry = priceTry;
    }

    @Column(name = "price_usd", precision = 22, scale = 0)
    public double getPriceUsd() {
        return this.priceUsd;
    }

    public void setPriceUsd(double priceUsd) {
        this.priceUsd = priceUsd;
    }

    @Column(name = "volume_24h_usd", precision = 22, scale = 0)
    public double getVolume24hUsd() {
        return this.volume24hUsd;
    }

    public void setVolume24hUsd(double volume24hUsd) {
        this.volume24hUsd = volume24hUsd;
    }

    @Column(name = "percent_change_1h_usd", precision = 22, scale = 0)
    public double getPercentChange1hUsd() {
        return this.percentChange1hUsd;
    }

    public void setPercentChange1hUsd(double percentChange1hUsd) {
        this.percentChange1hUsd = percentChange1hUsd;
    }

    @Column(name = "percent_change_24h_usd", precision = 22, scale = 0)
    public double getPercentChange24hUsd() {
        return this.percentChange24hUsd;
    }

    public void setPercentChange24hUsd(double percentChange24hUsd) {
        this.percentChange24hUsd = percentChange24hUsd;
    }

    @Column(name = "percent_change_7d_usd", precision = 22, scale = 0)
    public double getPercentChange7dUsd() {
        return this.percentChange7dUsd;
    }

    public void setPercentChange7dUsd(double percentChange7dUsd) {
        this.percentChange7dUsd = percentChange7dUsd;
    }

    @Column(name = "market_cap_usd", precision = 22, scale = 0)
    public double getMarketCapUsd() {
        return this.marketCapUsd;
    }

    public void setMarketCapUsd(double marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
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
