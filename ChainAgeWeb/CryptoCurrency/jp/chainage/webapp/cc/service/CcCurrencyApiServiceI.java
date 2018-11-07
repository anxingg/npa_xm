package jp.chainage.webapp.cc.service;

import java.util.List;

import org.jeecgframework.core.common.service.CommonService;

import jp.chainage.webapp.cc.entity.CcBtcMonitorRateHistory;
import jp.chainage.webapp.cc.page.AssetGeneral;
import jp.chainage.webapp.cc.page.AssetQuotation;
import jp.chainage.webapp.cc.page.BtcMonitor;
import jp.chainage.webapp.cc.page.ExchangeMarkInfo;
import jp.chainage.webapp.cc.page.ExchangeRiseFall;
import jp.chainage.webapp.cc.page.MarkInofExchange;

public interface CcCurrencyApiServiceI extends CommonService {
    /**
     * 所有交易所信息
     * 
     * @return
     * @throws Exception
     */
    public boolean exchanges(String key) throws Exception;

    /**
     * 所有资产信息
     * 
     * @return
     * @throws Exception
     */
    public boolean assets() throws Exception;

    /**
     * 所有标志信息
     * 
     * @return
     * @throws Exception
     */
    public boolean symbols() throws Exception;

    /**
     * 
     * @return
     * @throws Exception
     */
    public List<AssetQuotation> assetTrend() throws Exception;

    /**
     * BTC监视器固定法币汇率和OHLCV的历史信息
     * 
     * @return
     */
    public BtcMonitor btcMonitorLine_OHLCV() throws Exception;

    /**
     * BTC监控器的实时费率
     * 
     * @return
     * @throws Exception
     */
    public CcBtcMonitorRateHistory btcMonitorRate() throws Exception;

    /**
     * 24小时交易总量超过200BTC的交易市场
     * 
     * @return
     * @throws Exception
     */
    public void topMarketTrend() throws Exception;

    /**
     * 24小时交法币交易总量
     * 
     * @return
     * @throws Exception
     */
    public void legalcurrencyTrend() throws Exception;

    /**
     * 浮动大的前10位交易所
     * 
     * @return
     * @throws Exception
     */
    public List<ExchangeRiseFall> topFloatingExchange() throws Exception;

    /**
     * 资产概要信息
     * 
     * @return
     * @throws Exception
     */
    public List<AssetGeneral> assetsGeneral() throws Exception;

    /**
     * 以交易所为单位所有的市场信息
     * 
     * @param id 交易所id
     * @return
     * @throws Exception
     */
    public ExchangeMarkInfo exchangeMarketInfo(int id) throws Exception;

    /**
     * 以市场为单位所有的交易所信息
     * 
     * @param base
     * @param quot
     * @param start
     * @return
     * @throws Exception
     */
    public MarkInofExchange marketInfoExchange(int base, int quot, int start) throws Exception;
}
