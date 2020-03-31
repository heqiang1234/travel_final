package com.human.service;

import com.human.model.BrowseRecord;
import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.model.UserInterest;

import java.util.List;

public interface BrowseRecordService {


    void addBrowseRecord(String user_spot_id, String record_username, String record_time);

    int deleteBrowseRecord(String record_id);

    int deleteAllBrowseRecord(String record_username);

    PageBean<Scenic> selectAllBrowseRecordByName(int cur, int pag, String user_name);



}
