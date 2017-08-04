
package com.example.admin.rtr.ModelCallbyMonth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object {

    @SerializedName("start_time")
    @Expose
    private Long startTime;
    @SerializedName("end_time")
    @Expose
    private Long endTime;
    @SerializedName("in_calls")
    @Expose
    private Integer inCalls;
    @SerializedName("in_ans")
    @Expose
    private Integer inAns;
    @SerializedName("avg_ans")
    @Expose
    private Integer avgAns;
    @SerializedName("tot_tlk")
    @Expose
    private Integer totTlk;
    @SerializedName("avg_tlk")
    @Expose
    private Integer avgTlk;
    @SerializedName("in_abnd")
    @Expose
    private Integer inAbnd;
    @SerializedName("avg_abnd")
    @Expose
    private Integer avgAbnd;
    @SerializedName("out")
    @Expose
    private Integer out;
    @SerializedName("out_ans")
    @Expose
    private Integer outAns;
    @SerializedName("max_wait")
    @Expose
    private Integer maxWait;
    @SerializedName("avg_wait")
    @Expose
    private Integer avgWait;
    @SerializedName("svc")
    @Expose
    private Integer svc;
    @SerializedName("vm_redirects")
    @Expose
    private Integer vmRedirects;
    @SerializedName("avg_wrp_up")
    @Expose
    private Integer avgWrpUp;

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Integer getInCalls() {
        return inCalls;
    }

    public void setInCalls(Integer inCalls) {
        this.inCalls = inCalls;
    }

    public Integer getInAns() {
        return inAns;
    }

    public void setInAns(Integer inAns) {
        this.inAns = inAns;
    }

    public Integer getAvgAns() {
        return avgAns;
    }

    public void setAvgAns(Integer avgAns) {
        this.avgAns = avgAns;
    }

    public Integer getTotTlk() {
        return totTlk;
    }

    public void setTotTlk(Integer totTlk) {
        this.totTlk = totTlk;
    }

    public Integer getAvgTlk() {
        return avgTlk;
    }

    public void setAvgTlk(Integer avgTlk) {
        this.avgTlk = avgTlk;
    }

    public Integer getInAbnd() {
        return inAbnd;
    }

    public void setInAbnd(Integer inAbnd) {
        this.inAbnd = inAbnd;
    }

    public Integer getAvgAbnd() {
        return avgAbnd;
    }

    public void setAvgAbnd(Integer avgAbnd) {
        this.avgAbnd = avgAbnd;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getOutAns() {
        return outAns;
    }

    public void setOutAns(Integer outAns) {
        this.outAns = outAns;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getAvgWait() {
        return avgWait;
    }

    public void setAvgWait(Integer avgWait) {
        this.avgWait = avgWait;
    }

    public Integer getSvc() {
        return svc;
    }

    public void setSvc(Integer svc) {
        this.svc = svc;
    }

    public Integer getVmRedirects() {
        return vmRedirects;
    }

    public void setVmRedirects(Integer vmRedirects) {
        this.vmRedirects = vmRedirects;
    }

    public Integer getAvgWrpUp() {
        return avgWrpUp;
    }

    public void setAvgWrpUp(Integer avgWrpUp) {
        this.avgWrpUp = avgWrpUp;
    }

}
