
package com.example.admin.rtr.ModelHistoricCall;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoricCallResponse {

    @SerializedName("report_preset")
    @Expose
    private java.lang.Object reportPreset;
    @SerializedName("objects")
    @Expose
    private List<com.example.admin.rtr.ModelHistoricCall.Object> objects = null;
    @SerializedName("all_columns")
    @Expose
    private List<AllColumn> allColumns = null;
    @SerializedName("columns")
    @Expose
    private List<Column> columns = null;
    @SerializedName("phone_num_list")
    @Expose
    private List<PhoneNumList> phoneNumList = null;

    public java.lang.Object getReportPreset() {
        return reportPreset;
    }

    public void setReportPreset(java.lang.Object reportPreset) {
        this.reportPreset = reportPreset;
    }

    public List<com.example.admin.rtr.ModelHistoricCall.Object> getObjects() {
        return objects;
    }

    public void setObjects(List<com.example.admin.rtr.ModelHistoricCall.Object> objects) {
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

    public List<PhoneNumList> getPhoneNumList() {
        return phoneNumList;
    }

    public void setPhoneNumList(List<PhoneNumList> phoneNumList) {
        this.phoneNumList = phoneNumList;
    }

}
