
package com.example.admin.rtr.ModelAgentList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("start_time")
    @Expose
    private Long startTime;
    @SerializedName("end_time")
    @Expose
    private Long endTime;
    @SerializedName("dnd_status")
    @Expose
    private String dndStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getDndStatus() {
        return dndStatus;
    }

    public void setDndStatus(String dndStatus) {
        this.dndStatus = dndStatus;
    }

}
