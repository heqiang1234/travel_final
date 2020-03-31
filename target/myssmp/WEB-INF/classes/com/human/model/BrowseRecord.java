package com.human.model;

public class BrowseRecord {

    private static final long serialVersionUID = 8430941165882152228L;
    private int record_id;
    private String scenic_spot_id;
    private String record_username;
    private String record_time;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public String getScenic_spot_id() {
        return scenic_spot_id;
    }

    public void setScenic_spot_id(String scenic_spot_id) {
        this.scenic_spot_id = scenic_spot_id;
    }

    public String getRecord_username() {
        return record_username;
    }

    public void setRecord_username(String record_username) {
        this.record_username = record_username;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }
}
