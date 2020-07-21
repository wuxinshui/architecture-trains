package com.wxs.hash.redis;

public class AJResult {
    private Long time;
    private Long unionId;
    private Boolean result;

    public AJResult(Long time, Long unionId, Boolean result) {
        this.time = time;
        this.unionId = unionId;
        this.result = result;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUnionId() {
        return unionId;
    }

    public void setUnionId(Long unionId) {
        this.unionId = unionId;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
