package com.example.admin.rtr.ModelCallbyHalfnHour;

/**
 * Created by Admin on 20-07-2017.
 */

public class CallbyhalfnhourGroup
{
private String Time1,Time2;
private CallbyhalfnhourChild callbyhalfnhourChild;

    public CallbyhalfnhourGroup(String time1, String time2) {
        Time1 = time1;
        Time2 = time2;
    }

    public CallbyhalfnhourGroup(String time1, String time2, CallbyhalfnhourChild callbyhalfnhourChild) {
        Time1 = time1;
        Time2 = time2;
        this.callbyhalfnhourChild = callbyhalfnhourChild;
    }

    public String getTime1() {
        return Time1;
    }

    public void setTime1(String time1) {
        Time1 = time1;
    }

    public String getTime2() {
        return Time2;
    }

    public void setTime2(String time2) {
        Time2 = time2;
    }

    public CallbyhalfnhourChild getCallbyhalfnhourChild() {
        return callbyhalfnhourChild;
    }

    public void setCallbyhalfnhourChild(CallbyhalfnhourChild callbyhalfnhourChild) {
        this.callbyhalfnhourChild = callbyhalfnhourChild;
    }
}
