package com.human.service;

import com.human.model.ScenicDetail;

import java.util.HashMap;
import java.util.List;

public interface ScenicDetailService {

    /**
     * create by hq 2020/03/18 17:55
     * 根据景点ID获取详细信息
     *
     */
    ScenicDetail getScenic_DetailByScenic_Id(String S_ID);



}
