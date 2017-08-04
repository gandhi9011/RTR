
package com.example.admin.rtr.ModelUnreturnCall;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnreturnCallResponse {

    @SerializedName("objects")
    @Expose
    private List<Object> objects = null;
    @SerializedName("all_columns")
    @Expose
    private List<AllColumn> allColumns = null;
    @SerializedName("columns")
    @Expose
    private List<Column> columns = null;

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
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

}
