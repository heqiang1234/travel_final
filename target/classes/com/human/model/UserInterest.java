package com.human.model;

public class UserInterest {

    private static final long serialVersionUID = 8430941165882152228L;
    private int user_interset_id;
    private String user_spot_id;
    private String user_scenic_type;
    private String user_interest_time;
    private String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_interset_id() {
        return user_interset_id;
    }

    public void setUser_interset_id(int user_interset_id) {
        this.user_interset_id = user_interset_id;
    }

    public String getUser_spot_id() {
        return user_spot_id;
    }

    public void setUser_spot_id(String user_spot_id) {
        this.user_spot_id = user_spot_id;
    }

    public String getUser_scenic_type() {
        return user_scenic_type;
    }

    public void setUser_scenic_type(String user_scenic_type) {
        this.user_scenic_type = user_scenic_type;
    }

    public String getUser_interest_time() {
        return user_interest_time;
    }

    public void setUser_interest_time(String user_interest_time) {
        this.user_interest_time = user_interest_time;
    }
}
