
package com.example.admin.rtr.ModelAgentQueue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Callcenter {

    @SerializedName("avg_abnd")
    @Expose
    private Long avgAbnd;
    @SerializedName("call_miss")
    @Expose
    private Long callMiss;
    @SerializedName("in_abnd")
    @Expose
    private Long inAbnd;
    @SerializedName("wait_now")
    @Expose
    private Long waitNow;
    @SerializedName("max_wait")
    @Expose
    private Long maxWait;
    @SerializedName("overflowed")
    @Expose
    private Long overflowed;
    @SerializedName("transferred")
    @Expose
    private Long transferred;
    @SerializedName("svc")
    @Expose
    private Long svc;
    @SerializedName("avg_tlk")
    @Expose
    private Long avgTlk;
    @SerializedName("in_ans")
    @Expose
    private Long inAns;
    @SerializedName("esc")
    @Expose
    private Long esc;
    @SerializedName("in_bounced")
    @Expose
    private Long inBounced;
    @SerializedName("in")
    @Expose
    private Long in;
    @SerializedName("avg_wait")
    @Expose
    private Long avgWait;
    @SerializedName("tot_tlk")
    @Expose
    private Long totTlk;
    @SerializedName("available_agents")
    @Expose
    private Long availableAgents;
    @SerializedName("staffed_ratio")
    @Expose
    private String staffedRatio;
    @SerializedName("id")
    @Expose
    private String id;

    public Long getAvgAbnd() {
        return avgAbnd;
    }

    public void setAvgAbnd(Long avgAbnd) {
        this.avgAbnd = avgAbnd;
    }

    public Long getCallMiss() {
        return callMiss;
    }

    public void setCallMiss(Long callMiss) {
        this.callMiss = callMiss;
    }

    public Long getInAbnd() {
        return inAbnd;
    }

    public void setInAbnd(Long inAbnd) {
        this.inAbnd = inAbnd;
    }

    public Long getWaitNow() {
        return waitNow;
    }

    public void setWaitNow(Long waitNow) {
        this.waitNow = waitNow;
    }

    public Long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Long maxWait) {
        this.maxWait = maxWait;
    }

    public Long getOverflowed() {
        return overflowed;
    }

    public void setOverflowed(Long overflowed) {
        this.overflowed = overflowed;
    }

    public Long getTransferred() {
        return transferred;
    }

    public void setTransferred(Long transferred) {
        this.transferred = transferred;
    }

    public Long getSvc() {
        return svc;
    }

    public void setSvc(Long svc) {
        this.svc = svc;
    }

    public Long getAvgTlk() {
        return avgTlk;
    }

    public void setAvgTlk(Long avgTlk) {
        this.avgTlk = avgTlk;
    }

    public Long getInAns() {
        return inAns;
    }

    public void setInAns(Long inAns) {
        this.inAns = inAns;
    }

    public Long getEsc() {
        return esc;
    }

    public void setEsc(Long esc) {
        this.esc = esc;
    }

    public Long getInBounced() {
        return inBounced;
    }

    public void setInBounced(Long inBounced) {
        this.inBounced = inBounced;
    }

    public Long getIn() {
        return in;
    }

    public void setIn(Long in) {
        this.in = in;
    }

    public Long getAvgWait() {
        return avgWait;
    }

    public void setAvgWait(Long avgWait) {
        this.avgWait = avgWait;
    }

    public Long getTotTlk() {
        return totTlk;
    }

    public void setTotTlk(Long totTlk) {
        this.totTlk = totTlk;
    }

    public Long getAvailableAgents() {
        return availableAgents;
    }

    public void setAvailableAgents(Long availableAgents) {
        this.availableAgents = availableAgents;
    }

    public String getStaffedRatio() {
        return staffedRatio;
    }

    public void setStaffedRatio(String staffedRatio) {
        this.staffedRatio = staffedRatio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
