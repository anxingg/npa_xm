package jp.chainage.webapp.cc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cc_symbol", schema = "")
public class Symbol implements java.io.Serializable {
    private static final long serialVersionUID = -6994453415262776140L;

    private Integer id;
    private String symbolId;
    private String exchangeId;
    private String symbolType;
    private String assetIdBase;
    private String assetIdQuote;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "symbol_id", nullable = false)
    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }

    @Column(name = "exchange_id", nullable = false)
    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Column(name = "symbol_type", nullable = false)
    public String getSymbolType() {
        return symbolType;
    }

    public void setSymbolType(String symbolType) {
        this.symbolType = symbolType;
    }

    @Column(name = "asset_id_base", nullable = false)
    public String getAssetIdBase() {
        return assetIdBase;
    }

    public void setAssetIdBase(String assetIdBase) {
        this.assetIdBase = assetIdBase;
    }

    @Column(name = "asset_id_quote", nullable = false)
    public String getAssetIdQuote() {
        return assetIdQuote;
    }

    public void setAssetIdQuote(String assetIdQuote) {
        this.assetIdQuote = assetIdQuote;
    }
}
