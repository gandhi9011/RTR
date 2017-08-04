
package com.example.admin.rtr.ModelAgentQueue;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentQueueResponse {

    @SerializedName("all_columns_combined")
    @Expose
    private List<List<AllColumnsCombined>> allColumnsCombined = null;
    @SerializedName("objects")
    @Expose
    private List<com.example.admin.rtr.ModelAgentQueue.Object> objects = null;
    @SerializedName("report_preset")
    @Expose
    private java.lang.Object reportPreset;

    public List<List<AllColumnsCombined>> getAllColumnsCombined() {
        return allColumnsCombined;
    }

    public void setAllColumnsCombined(List<List<AllColumnsCombined>> allColumnsCombined) {
        this.allColumnsCombined = allColumnsCombined;
    }

    public List<com.example.admin.rtr.ModelAgentQueue.Object> getObjects() {
        return objects;
    }

    public void setObjects(List<com.example.admin.rtr.ModelAgentQueue.Object> objects) {
        this.objects = objects;
    }

    public java.lang.Object getReportPreset() {
        return reportPreset;
    }

    public void setReportPreset(java.lang.Object reportPreset) {
        this.reportPreset = reportPreset;
    }

}
