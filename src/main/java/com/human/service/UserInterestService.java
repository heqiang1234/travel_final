package com.human.service;

import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.model.UserInterest;

import java.util.HashMap;
import java.util.List;

public interface UserInterestService {


    void addUser_Interest(String user_spot_id,String user_name,String user_scenic_type,String user_interest_time );

    void updateUser_Interest(String interest_id,String user_spot_id,String user_name,String user_scenic_type,String user_interest_time );

    int deleteUserInter (String user_interest_id);

    PageBean<Scenic> selectAllUserInterByName (int cur, int pag, String user_name);

    /**
     * 查看是否存在
     * @param
     * @return
     */
    List<UserInterest> checkIsHave (String type,String user_name,String user_spot_id);



}
