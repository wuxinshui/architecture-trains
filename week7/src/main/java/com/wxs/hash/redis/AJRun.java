package com.wxs.hash.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class AJRun {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private int times;
    private ExecutorService executorService;
    private List<AJTask> tasks;

    public AJRun(int times, List<AJTask> tasks) {
        this.times = times;
        this.executorService = new ThreadPoolExecutor(times, times,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(times * 2));
        this.tasks = tasks;
    }

    public List<AJResult> execute() {
        List<AJResult> resultList = new ArrayList<>();
        IntStream.iterate(0, i -> (i < times), i -> i + 1).forEach(it -> {
            logger.info("execute times:{}", it);
            List<Future<AJResult>> futureList = null;
            try {
                futureList = executorService.invokeAll(tasks);
                futureList.forEach(o -> {
                    try {
                        AJResult result = o.get();
                        Long id = result.getUnionId();
                        result.setUnionId(Long.valueOf(it + "" + id));
                        resultList.add(result);
                        logger.info("execute success:{}-{} thread-{}", it, id, Thread.currentThread());
                    } catch (InterruptedException e) {
                        logger.error("InterruptedException:{}", e);
                    } catch (ExecutionException e) {
                        logger.error("ExecutionException:{}", e);
                    }
                });
            } catch (InterruptedException e) {
                logger.error("execute times:{},InterruptedException:{}", it, e);
            }
        });

        return resultList;
    }

}
