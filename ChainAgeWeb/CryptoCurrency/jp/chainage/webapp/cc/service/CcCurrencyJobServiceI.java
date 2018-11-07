package jp.chainage.webapp.cc.service;

import org.jeecgframework.core.common.service.CommonService;

public interface CcCurrencyJobServiceI extends CommonService {
    /**
     * 更新行情固定的资产的交易费率变化信息缓存(计划任务调用)
     * 
     * @return
     * @throws Exception
     */
    public boolean setAssetsQuotationRateCurrent_Job() throws Exception;

    /**
     * 更新行情固定的资产的交易费率变化24h历史信息缓存(计划任务调用)
     * 
     * @return
     * @throws Exception
     */
    public boolean setAssetsQuotationRateHistory24h_Job() throws Exception;

    /**
     * 更新资产概要信息缓存(计划任务调用)
     * 
     * @return
     * @throws Exception 
     */
    public boolean setAssetsGeneral_Job() throws Exception;

    /**
     * 更新24小时交易总量超过200BTC的交易市场信息缓存(计划任务调用)
     * 
     * @return
     * @throws Exception
     */
    public void setTopMarketTrend_Job() throws Exception;

    /**
     * 更新24小时交法币交易总量信息缓存(计划任务调用)
     * 
     * @return
     * @throws Exception
     */
    public boolean setLegalcurrencyTrend_Job() throws Exception;

    /**
     * 更新浮动大的前10位交易所信息缓存(计划任务调用)
     * 
     * @return
     * @throws Exception
     */
    public boolean setTopFloatingExchange_Job() throws Exception;

    /**
     * 更新以交易所为单位所有的市场信息
     * 
     * @return
     * @throws Exception
     */
    public boolean setExchangeMarkInfo_Job() throws Exception;

    /**
     * 更新以市场为单位所有的交易所信息
     * 
     * @return
     * @throws Exception
     */
    public boolean setMarkInfoExchange_Job() throws Exception;

    /**
     * 更新BTC监视器固定法币汇率和OHLCV的历史信息(计划任务调用)
     * 
     * @return
     * @throws Exception
     */
    public boolean setBtcMonitorLine_OHLCV_Job() throws Exception;

    /**
     * 更新BTC监视器的费率信息(计划任务调用)
     * 
     * @return
     * @throws Exception
     */
    public boolean setBtcMonitorRate_Job() throws Exception;
}
