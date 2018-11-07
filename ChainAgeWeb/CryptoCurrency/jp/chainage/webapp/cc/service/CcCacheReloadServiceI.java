package jp.chainage.webapp.cc.service;

import org.jeecgframework.core.common.service.CommonService;

public interface CcCacheReloadServiceI extends CommonService {
    /**
     * 刷新交易所信息
     * 
     * @return
     * @throws Exception
     */
    public boolean exchanges() throws Exception;

    /**
     * 刷新资产信息
     * 
     * @return
     * @throws Exception
     */
    public boolean assets() throws Exception;

    /**
     * 刷新标志信息
     * 
     * @return
     * @throws Exception
     */
    public boolean symbols() throws Exception;

    /**
     * 刷新xx1历史信息
     * 
     * @return
     * @throws Exception
     */
    public boolean xx1() throws Exception;
}
