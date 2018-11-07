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
 * 以交易所为单位所有的市场信息器的费率信息-定时任务
 * 
 * @author zhaoqi
 *
 */
@Service("ccCurrencyMarkInfoExchangeTask")
public class CcCurrencyMarkInfoExchangeTask implements Job {
    private static final Logger logger = LoggerFactory.getLogger(CcCurrencyMarkInfoExchangeTask.class);

    @Autowired
    private CcCurrencyJobServiceI ccCurrencyJobService;

    public void run() {
        try {
            ccCurrencyJobService.setMarkInfoExchange_Job();
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
