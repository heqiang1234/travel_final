package com.human.model;

/**
 * create by hq on 2020/03/18
 * 景点信息表
 */
public class Scenic {
    private static final long serialVersionUID = 8430941165882152228L;
    private int  scenic_id;
    private String  scenic_name;
    private String  scenic_area;
    private String  scenic_spot_id;
    private String  scenic_type;
    private String  scenic_level;
    private String  scenic_heat;
    private String  scenic_address;
    private String  scenic_latitude;
    private String  scenic_feature;
    private String  scenic_img;
    private String  scenic_crawltime;
    private String  scenic_city;
    private ScenicDetail scenicDetail;

    public String getScenic_city() {
        return scenic_city;
    }

    public void setScenic_city(String scenic_city) {
        this.scenic_city = scenic_city;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getScenic_id() {
        return scenic_id;
    }

    public void setScenic_id(int scenic_id) {
        this.scenic_id = scenic_id;
    }

    public String getScenic_name() {
        return scenic_name;
    }

    public void setScenic_name(String scenic_name) {
        this.scenic_name = scenic_name;
    }

    public String getScenic_area() {
        return scenic_area;
    }

    public void setScenic_area(String scenic_area) {
        this.scenic_area = scenic_area;
    }

    public String getScenic_spot_id() {
        return scenic_spot_id;
    }

    public void setScenic_spot_id(String scenic_spot_id) {
        this.scenic_spot_id = scenic_spot_id;
    }

    public String getScenic_type() {
        return scenic_type;
    }

    public void setScenic_type(String scenic_type) {
        this.scenic_type = scenic_type;
    }

    public String getScenic_level() {
        return scenic_level;
    }

    public void setScenic_level(String scenic_level) {
        this.scenic_level = scenic_level;
    }

    public String getScenic_heat() {
        return scenic_heat;
    }

    public void setScenic_heat(String scenic_heat) {
        this.scenic_heat = scenic_heat;
    }

    public String getScenic_address() {
        return scenic_address;
    }

    public void setScenic_address(String scenic_address) {
        this.scenic_address = scenic_address;
    }

    public String getScenic_latitude() {
        return scenic_latitude;
    }

    public void setScenic_latitude(String scenic_latitude) {
        this.scenic_latitude = scenic_latitude;
    }

    public String getScenic_feature() {
        return scenic_feature;
    }

    public void setScenic_feature(String scenic_feature) {
        this.scenic_feature = scenic_feature;
    }

    public String getScenic_img() {
        return scenic_img;
    }

    public void setScenic_img(String scenic_img) {
        this.scenic_img = scenic_img;
    }

    public String getScenic_crawltime() {
        return scenic_crawltime;
    }

    public void setScenic_crawltime(String scenic_crawltime) {
        this.scenic_crawltime = scenic_crawltime;
    }

    public ScenicDetail getScenicDetail() {
        return scenicDetail;
    }

    public void setScenicDetail(ScenicDetail scenicDetail) {
        this.scenicDetail = scenicDetail;
    }
}
