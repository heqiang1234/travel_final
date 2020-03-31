package com.human.dao;

import com.human.model.BrowseRecord;

import java.util.HashMap;
import java.util.List;

public interface BrowseRecordDao {

    /**
     * 添加浏览记录
     * @param map
     * @return
     */
    void addBrowseRecord (HashMap<String, Object> map);

    /**
     * 删除浏览记录
     * @param map
     * @return
     */
    int deleteBrowseRecord (HashMap<String, Object> map);


    /**
     * 删除所有浏览记录
     * @param
     * @return
     */
    int deleteAllBrowseRecord (HashMap<String, Object> map);


    /**
     * 得到浏览记录数量
     * @param map
     * @return
     */
    int getBrowseRecordCount (HashMap<String, Object> map);


    /**
     * 查看所有浏览记录
     * @param map
     * @return
     */
    List<BrowseRecord> selectAllBrowseRecordByName (HashMap<String, Object> map);

}
