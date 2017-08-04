
package com.example.admin.rtr.ModelDashboard;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DesktopWallboardResponse {

    @SerializedName("objects")
    @Expose
    private List<com.example.admin.rtr.ModelDashboard.Object> objects = null;
    @SerializedName("all_columns")
    @Expose
    private List<AllColumn> allColumns = null;
    @SerializedName("columns")
    @Expose
    private List<Column> columns = null;
    @SerializedName("report_preset")
    @Expose
    private java.lang.Object reportPreset;

    public List<com.example.admin.rtr.ModelDashboard.Object> getObjects() {
        return objects;
    }

    public void setObjects(List<com.example.admin.rtr.ModelDashboard.Object> objects) {
        this.objects = objects;
    }

    public List<AllColumn> getAllColumns() {
        return allColumns;
    }

    public void setAllColumns(List<AllColumn> allColumns) {
        this.allColumns = allColumns;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public java.lang.Object getReportPreset() {
        return reportPreset;
    }

    public void setReportPreset(java.lang.Object reportPreset) {
        this.reportPreset = reportPreset;
    }

}
