
package com.example.admin.rtr.ModelAgentQueue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Agent {

    @SerializedName("out_tot_tlk")
    @Expose
    private Long outTotTlk;
    @SerializedName("dnd_status")
    @Expose
    private String dndStatus;
    @SerializedName("idle_time")
    @Expose
    private Long idleTime;
    @SerializedName("out_int")
    @Expose
    private Long outInt;
    @SerializedName("in")
    @Expose
    private Long in;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("out")
    @Expose
    private Long out;
    @SerializedName("in_out_tot_tlk")
    @Expose
    private Long inOutTotTlk;
    @SerializedName("vm_redirects")
    @Expose
    private Long vmRedirects;
    @SerializedName("dnd_timestamp")
    @Expose
    private Long dndTimestamp;
    @SerializedName("out_ext")
    @Expose
    private Long outExt;
    @SerializedName("in_ans")
    @Expose
    private Long inAns;
    @SerializedName("in_out")
    @Expose
    private Long inOut;
    @SerializedName("status_timestamp")
    @Expose
    private Long statusTimestamp;
    @SerializedName("out_ans")
    @Expose
    private Long outAns;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("in_abnd")
    @Expose
    private Long inAbnd;
    @SerializedName("avg_out_tlk")
    @Expose
    private Long avgOutTlk;
    @SerializedName("avg_tlk")
    @Expose
    private Long avgTlk;
    @SerializedName("tot_tlk")
    @Expose
    private Long totTlk;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("transferred")
    @Expose
    private Long transferred;
    @SerializedName("in_out_avg")
    @Expose
    private Double inOutAvg;
    @SerializedName("in_state_for")
    @Expose
    private Long inStateFor;

    public Long getOutTotTlk() {
        return outTotTlk;
    }

    public void setOutTotTlk(Long outTotTlk) {
        this.outTotTlk = outTotTlk;
    }

    public String getDndStatus() {
        return dndStatus;
    }

    public void setDndStatus(String dndStatus) {
        this.dndStatus = dndStatus;
    }

    public Long getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(Long idleTime) {
        this.idleTime = idleTime;
    }

    public Long getOutInt() {
        return outInt;
    }

    public void setOutInt(Long outInt) {
        this.outInt = outInt;
    }

    public Long getIn() {
        return in;
    }

    public void setIn(Long in) {
        this.in = in;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOut() {
        return out;
    }

    public void setOut(Long out) {
        this.out = out;
    }

    public Long getInOutTotTlk() {
        return inOutTotTlk;
    }

    public void setInOutTotTlk(Long inOutTotTlk) {
        this.inOutTotTlk = inOutTotTlk;
    }

    public Long getVmRedirects() {
        return vmRedirects;
    }

    public void setVmRedirects(Long vmRedirects) {
        this.vmRedirects = vmRedirects;
    }

    public Long getDndTimestamp() {
        return dndTimestamp;
    }

    public void setDndTimestamp(Long dndTimestamp) {
        this.dndTimestamp = dndTimestamp;
    }

    public Long getOutExt() {
        return outExt;
    }

    public void setOutExt(Long outExt) {
        this.outExt = outExt;
    }

    public Long getInAns() {
        return inAns;
    }

    public void setInAns(Long inAns) {
        this.inAns = inAns;
    }

    public Long getInOut() {
        return inOut;
    }

    public void setInOut(Long inOut) {
        this.inOut = inOut;
    }

    public Long getStatusTimestamp() {
        return statusTimestamp;
    }

    public void setStatusTimestamp(Long statusTimestamp) {
        this.statusTimestamp = statusTimestamp;
    }

    public Long getOutAns() {
        return outAns;
    }

    public void setOutAns(Long outAns) {
        this.outAns = outAns;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getInAbnd() {
        return inAbnd;
    }

    public void setInAbnd(Long inAbnd) {
        this.inAbnd = inAbnd;
    }

    public Long getAvgOutTlk() {
        return avgOutTlk;
    }

    public void setAvgOutTlk(Long avgOutTlk) {
        this.avgOutTlk = avgOutTlk;
    }

    public Long getAvgTlk() {
        return avgTlk;
    }

    public void setAvgTlk(Long avgTlk) {
        this.avgTlk = avgTlk;
    }

    public Long getTotTlk() {
        return totTlk;
    }

    public void setTotTlk(Long totTlk) {
        this.totTlk = totTlk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTransferred() {
        return transferred;
    }

    public void setTransferred(Long transferred) {
        this.transferred = transferred;
    }

    public Double getInOutAvg() {
        return inOutAvg;
    }

    public void setInOutAvg(Double inOutAvg) {
        this.inOutAvg = inOutAvg;
    }

    public Long getInStateFor() {
        return inStateFor;
    }

    public void setInStateFor(Long inStateFor) {
        this.inStateFor = inStateFor;
    }

}
