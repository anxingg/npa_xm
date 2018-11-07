package jp.chainage.webapp.cc.controller;

import java.util.List;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.CacheServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.chainage.webapp.cc.page.AssetGeneral;
import jp.chainage.webapp.cc.page.AssetQuotation;
import jp.chainage.webapp.cc.page.BtcMonitor;
import jp.chainage.webapp.cc.page.ExchangeMarkInfo;
import jp.chainage.webapp.cc.page.ExchangeRiseFall;
import jp.chainage.webapp.cc.page.MarkInofExchange;
import jp.chainage.webapp.cc.service.CcCurrencyApiServiceI;
import jp.chainage.webapp.cc.service.CcCurrencyJobServiceI;

/**
 * @Title: Controller
 * @Description: 数字加密货币提供服务
 * @author 赵琦
 * @date 2018-09-03 18:00:00
 * @version V1.0
 *
 */
@Api(value = "ccCurrencyApi", description = "数字加密货币提供服务", tags = "CcCurrencyApiController")
@RequestMapping("/cc/currencyApiController")
@RestController
public class CcCurrencyApiController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(CcCurrencyApiController.class);

    /*--------------------------------------------
    |             Variable                       |
    ============================================*/

    /*--------------------------------------------
    |             Injection                      |
    ============================================*/
    @Autowired
    private CcCurrencyApiServiceI ccCurrencyApiService;

    @Autowired
    private CcCurrencyJobServiceI ccCurrencyJobService;

    @Autowired
    private CacheServiceI cacheService;

    /*--------------------------------------------
    |             method                       |
    ============================================*/
    /**
     * 获取assetTrend信息
     * 
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取assetTrend信息", notes = "获取assetTrend信息", httpMethod = "GET")
    @RequestMapping(params = "assetTrend", method = RequestMethod.GET)
    public List<AssetQuotation> assetTrend() throws Exception {
        List<AssetQuotation> list = ccCurrencyApiService.assetTrend();
        return list;
    }

    /**
     * 获取BTC Monitor信息
     * 
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取BTC Monitor信息", notes = "获取BTC Monitor信息", httpMethod = "GET")
    @RequestMapping(params = "btcMonitorLineOHLCV", method = RequestMethod.GET)
    public BtcMonitor btcMonitorLineOHLCV() throws Exception {
        BtcMonitor btcMonitor = ccCurrencyApiService.btcMonitorLine_OHLCV();
        return btcMonitor;
    }

    /**
     * 获取BTC Monitor的实时费率
     * 
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取BTC Monitor的实时费率", notes = "获取BTC Monitor的实时费率", httpMethod = "GET")
    @RequestMapping(params = "btcMonitorRate", method = RequestMethod.GET)
    public BtcMonitor btcMonitorRate() throws Exception {
        BtcMonitor btcMonitor = ccCurrencyApiService.btcMonitorLine_OHLCV();
        return btcMonitor;
    }

    /**
     * 24小时交易总量超过200BTC的交易市场
     * 
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "24小时交易总量超过200BTC的交易市场", notes = "24小时交易总量超过200BTC的交易市场", httpMethod = "GET")
    @RequestMapping(params = "topTrendingMarket", method = RequestMethod.GET)
    public String topMarketTrend() throws Exception {
        return "true";
    }

    /**
     * 24小时交法币交易总量
     * 
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "24小时交法币交易总量", notes = "24小时交法币交易总量", httpMethod = "GET")
    @RequestMapping(params = "legalCurrencyTrend", method = RequestMethod.GET)
    public String legalCurrencyTrend() throws Exception {
        return "true";
    }

    /**
     * 浮动大的前10位交易所
     * 
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "浮动大的前10位交易所", notes = "浮动大的前10位交易所", httpMethod = "GET")
    @RequestMapping(params = "topFloatingExchange", method = RequestMethod.GET)
    public List<ExchangeRiseFall> topFloatingExchange() throws Exception {
        List<ExchangeRiseFall> list = ccCurrencyApiService.topFloatingExchange();
        return list;
    }

    /**
     * 以交易所为单位所有的市场信息
     * 
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "以交易所为单位所有的市场信息", notes = "以交易所为单位所有的市场信息", httpMethod = "GET")
    @RequestMapping(params = "exchangeMarketInfo", method = RequestMethod.GET)
    public ExchangeMarkInfo exchangeMarketInfo(
            @ApiParam(name = "id", value = "交易所id", required = true) @RequestParam(value = "id", required = true) int id)
            throws Exception {
        ExchangeMarkInfo exchangeMarkInfo = ccCurrencyApiService.exchangeMarketInfo(id);
        return exchangeMarkInfo;
    }

    /**
     * 以市场为单位所有的交易所信息
     * 
     * @param base
     * @param quot
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "以市场为单位所有的交易所信息", notes = "以市场为单位所有的交易所信息", httpMethod = "GET")
    @RequestMapping(params = "marketInfoExchange", method = RequestMethod.GET)
    public MarkInofExchange marketInfoExchange(
            @ApiParam(name = "base", value = " 基准货币id", required = true) @RequestParam(value = "base", required = true) int base,
            @ApiParam(name = "quot", value = " 基准货币id", required = true) @RequestParam(value = "quot", required = true) int quot,
            @ApiParam(name = "page", value = "分页", required = true) @RequestParam(value = "page", required = true) int page) {
        MarkInofExchange markInfoExchange = null;
        try {
            markInfoExchange = ccCurrencyApiService.marketInfoExchange(base, quot, page);
        } catch (Exception e) {
            // TODO Auto-generated catch block
             e.printStackTrace();
        }
        return markInfoExchange;
    }

    /**
     * 获取asset的概要信息
     * 
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "获取asset的概要信息", notes = "获取asset的概要信息", httpMethod = "GET")
    @RequestMapping(params = "assetsGeneral", method = RequestMethod.GET)
    public List<AssetGeneral> assetsGeneral() throws Exception {
        List<AssetGeneral> list = ccCurrencyApiService.assetsGeneral();
        return list;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(params = "exchanges1", method = RequestMethod.GET)
    public String exchanges1() throws Exception {
        // ccCurrencyJobService.setAssetsQuotationHolder_Job(new String[] {"BTC",
        // "BCH"});
        // ccCurrencyJobService.setAssetsQuotationRateCurrent_Job(new String[] {"BTC",
        // "BCH"});
        // ccCurrencyJobService.setAssetsQuotationRateHistoryMonth_Job(new String[]
        // {"BTC", "BCH"});
        // ccCurrencyJobService.setAssetsGeneral_Job();
        // ccCurrencyJobService.setLegalcurrencyTrend_Job();

        //cacheService.clean(CacheServiceI.CURRENCY_API);
        // 首页16个卡片的波形数据
//        ccCurrencyJobService.setAssetsQuotationRateHistory24h_Job("BTC,BCH,ETH,ETC,XRP,EOS,MIOTA,XLM,LTC,ADA,XMR,DASH,TRX,NEO,XEM,VET".split(","));
//
//        // 首页16个卡片初始化
//        ccCurrencyJobService.setAssetsQuotationRateCurrent_Job();
//        List<AssetQuotation> currentData = (List<AssetQuotation>) cacheService.get(CacheServiceI.CURRENCY_API, ResourceUtil.ASSETS_QUOTATION_RATE);
//        String[] symbols = new String[currentData.size()];
//        for (int i = 0; i < currentData.size(); i++)
//            symbols[i] = currentData.get(i).getSymbol();
//        ccCurrencyJobService.setAssetsQuotationRateHistory24h_Job(symbols);
//
//        // 价格浮动大的前10位交易所以及后十名
//        ccCurrencyJobService.setTopFloatingExchange_Job();

        // ccCurrencyJobService.setBtcMonitorLine_OHLCV();
        return "true";
    }
}
