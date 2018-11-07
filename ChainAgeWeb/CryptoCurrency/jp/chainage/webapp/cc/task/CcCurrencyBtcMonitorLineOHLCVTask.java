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
 * BTC监视器的Line and ohlcv信息缓存 -定时任务
 * 
 * @author zhaoqi
 *
 */
@Service("ccCurrencyBtcMonitorLineOHLCVTask")
public class CcCurrencyBtcMonitorLineOHLCVTask implements Job {
    private static final Logger logger = LoggerFactory.getLogger(CcCurrencyBtcMonitorLineOHLCVTask.class);

    @Autowired
    private CcCurrencyJobServiceI ccCurrencyJobService;

    public void run() {
        try {
            ccCurrencyJobService.setBtcMonitorLine_OHLCV_Job();
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
