package com.example.xxljobsample.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BatchProcessJob {
    @XxlJob("batchProcessJob")
    public void batchProcessJob() throws Exception {
        log.info("This time we have aggregated 3100 pieces of data.");
        XxlJobHelper.log("The batch processing of data is finished.");
    }
}
