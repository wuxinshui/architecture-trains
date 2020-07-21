package com.wxs.ajmeter;

public class AJReport {

    private Double average;
    private Long min;
    private Long max;
    private Long errorRate;
    private Long percent95;

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(Long errorRate) {
        this.errorRate = errorRate;
    }

    public Long getPercent95() {
        return percent95;
    }

    public void setPercent95(Long percent95) {
        this.percent95 = percent95;
    }

    @Override
    public String toString() {
        return "AJReport{" +
                "average=" + average +
                ", min=" + min +
                ", max=" + max +
                ", errorRate=" + errorRate +
                ", percent95=" + percent95 +
                '}';
    }
}
