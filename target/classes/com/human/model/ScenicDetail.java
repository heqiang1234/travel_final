package com.human.model;

import java.util.List;

public class ScenicDetail {
    private static final long serialVersionUID = 8430941165882152228L;
    private int scenic_detail_id;
    private String scenic_spot_id;
    private String scenic_detail_name;
    private String scenic_detail_level;
    private String scenic_detail_address;
    private String scenic_detail_onesentence;
    private String scenic_detail_commentscore;
    private String scenic_detail_price;
    private String scenic_detail_intro;

    private List<ScenicDetailImg> scenicDetailImgList;

    private List<ScenicDetailTip> scenicDetailTipList;

    public int getScenic_detail_id() {
        return scenic_detail_id;
    }

    public void setScenic_detail_id(int scenic_detail_id) {
        this.scenic_detail_id = scenic_detail_id;
    }

    public String getScenic_spot_id() {
        return scenic_spot_id;
    }

    public void setScenic_spot_id(String scenic_spot_id) {
        this.scenic_spot_id = scenic_spot_id;
    }

    public String getScenic_detail_name() {
        return scenic_detail_name;
    }

    public void setScenic_detail_name(String scenic_detail_name) {
        this.scenic_detail_name = scenic_detail_name;
    }

    public String getScenic_detail_level() {
        return scenic_detail_level;
    }

    public void setScenic_detail_level(String scenic_detail_level) {
        this.scenic_detail_level = scenic_detail_level;
    }

    public String getScenic_detail_address() {
        return scenic_detail_address;
    }

    public void setScenic_detail_address(String scenic_detail_address) {
        this.scenic_detail_address = scenic_detail_address;
    }

    public String getScenic_detail_onesentence() {
        return scenic_detail_onesentence;
    }

    public void setScenic_detail_onesentence(String scenic_detail_onesentence) {
        this.scenic_detail_onesentence = scenic_detail_onesentence;
    }

    public String getScenic_detail_commentscore() {
        return scenic_detail_commentscore;
    }

    public void setScenic_detail_commentscore(String scenic_detail_commentscore) {
        this.scenic_detail_commentscore = scenic_detail_commentscore;
    }

    public String getScenic_detail_price() {
        return scenic_detail_price;
    }

    public void setScenic_detail_price(String scenic_detail_price) {
        this.scenic_detail_price = scenic_detail_price;
    }

    public String getScenic_detail_intro() {
        return scenic_detail_intro;
    }

    public void setScenic_detail_intro(String scenic_detail_intro) {
        this.scenic_detail_intro = scenic_detail_intro;
    }

    public List<ScenicDetailImg> getScenicDetailImgList() {
        return scenicDetailImgList;
    }

    public void setScenicDetailImgList(List<ScenicDetailImg> scenicDetailImgList) {
        this.scenicDetailImgList = scenicDetailImgList;
    }

    public List<ScenicDetailTip> getScenicDetailTipList() {
        return scenicDetailTipList;
    }

    public void setScenicDetailTipList(List<ScenicDetailTip> scenicDetailTipList) {
        this.scenicDetailTipList = scenicDetailTipList;
    }
}
