package com.wxs.ajmeter;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

public class AJTask implements Callable<AJResult> {

    private static final RestTemplate restTemplate = new RestTemplate();
    /**
     * 请求url
     */
    private String url;

    /**
     * 任务ID
     */
    private Long unionId;


    @Override
    public AJResult call() throws Exception {
        StopWatch stopWatch = new StopWatch(unionId.toString());
        stopWatch.start();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        stopWatch.stop();

        return new AJResult(stopWatch.getTotalTimeMillis(), unionId, responseEntity.getStatusCodeValue() == 200);
    }

    public AJTask(String url, Long id) {
        this.url = url;
        this.unionId = id;
    }

    public AJTask(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }
}
