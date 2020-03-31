package com.human.dao;

import com.human.model.ScenicDetail;

import java.util.HashMap;
import java.util.List;


/**
 * create by hq 2020/03/18 17:58
 */

public interface ScenicDetailDao {

    /**
     * 查询所有景点详情数据
     * @return
     */
    List<ScenicDetail> selectAllScenicDetail();

    /**
     * create by hq 2020/03/18 17:55
     * 根据景点ID获取详细信息
     *
     */
    ScenicDetail getScenic_DetailByScenic_Id(HashMap<String, Object> map);





}
