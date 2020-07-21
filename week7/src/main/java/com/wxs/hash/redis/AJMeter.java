package com.wxs.hash.redis;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AJMeter {
    /**
     * 请求总数
     */
    private int n;
    /**
     * 并发数
     */
    private int c;

    /**
     * 请求url
     */
    private String url;

    private List<AJTask> ajTasks;

    private AJRun ajRun;

    public AJMeter() {
    }

    public AJMeter(int n, int c, String url) {
        this.n = n;
        this.c = c;
        this.url = url;
        initTaskList(c);
        initRun();
    }

    private void initTaskList(int num) {
        ajTasks = new ArrayList<>();
        IntStream.iterate(0, i -> (i < num), i -> i + 1).forEach(o -> {
            Long uId = Long.valueOf(o);
            ajTasks.add(new AJTask(url, uId));
        });
    }

    private void initRun() {
        ajRun = new AJRun(n, ajTasks);
    }


    public List<AJResult> execute() {
        List<AJResult> futureList = ajRun.execute();
        return futureList;
    }

    public AJReport prettyResult(List<AJResult> results) {
        AJReport ajReport = new AJReport();
        Long min = results.stream().map(o -> o.getTime()).min(Long::compareTo).get();
        Long max = results.stream().map(o -> o.getTime()).max(Long::compareTo).get();
        Double avg = results.stream().mapToLong(o -> o.getTime()).average().getAsDouble();

        Long error = results.stream().filter(o -> !o.getResult()).count();

        ajReport.setMin(min);
        ajReport.setMax(max);
        ajReport.setAverage(avg);
        ajReport.setErrorRate(new BigDecimal(error).divide(new BigDecimal(results.size())).setScale(2).longValue());
        int index = new BigDecimal(results.size()).multiply(new BigDecimal(0.95)).setScale(0, RoundingMode.HALF_UP).intValue();
        ajReport.setPercent95(results.get(index).getTime());


        return ajReport;

    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
