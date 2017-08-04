package com.example.admin.rtr.Historic_Call;

/**
 * Created by Admin on 24-07-2017.
 */

public class ListItem
{

    private String  St_historic_date,St_historic_duration,St_historic_from,St_historic_to ;

    public ListItem(String st_historic_date, String st_historic_duration, String st_historic_from, String st_historic_to) {
        St_historic_date = st_historic_date;
        St_historic_duration = st_historic_duration;
        St_historic_from = st_historic_from;
        St_historic_to = st_historic_to;
    }

    public String getSt_historic_date() {
        return St_historic_date;
    }

    public void setSt_historic_date(String st_historic_date) {
        St_historic_date = st_historic_date;
    }

    public String getSt_historic_duration() {
        return St_historic_duration;
    }

    public void setSt_historic_duration(String st_historic_duration) {
        St_historic_duration = st_historic_duration;
    }

    public String getSt_historic_from() {
        return St_historic_from;
    }

    public void setSt_historic_from(String st_historic_from) {
        St_historic_from = st_historic_from;
    }

    public String getSt_historic_to() {
        return St_historic_to;
    }

    public void setSt_historic_to(String st_historic_to) {
        St_historic_to = st_historic_to;
    }
}