package jp.chainage.webapp.cc.task;

import java.io.IOException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.chainage.webapp.cc.service.CcCurrencyJobServiceI;

/**
 * 行情固定的资产的交易费率变化信息缓存-定时任务
 * 
 * @author zhaoqi
 *
 */
@Service("ccCurrencyAssetsQuotationRateCurrentTask")
public class CcCurrencyAssetsQuotationRateCurrentTask implements Job {
    private static final Logger logger = LoggerFactory.getLogger(CcCurrencyAssetsQuotationRateCurrentTask.class);

    @Autowired
    private CcCurrencyJobServiceI ccCurrencyJobService;

    public void run() {
        try {
            ccCurrencyJobService.setAssetsQuotationRateCurrent_Job();
        } catch (IOException ioe) {
            logger.error("coinMarketCap API 请求异常!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        run();
    }
}
