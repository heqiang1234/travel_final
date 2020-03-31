package com.human.dao;

import com.human.model.ScenicDetailTip;
import java.util.HashMap;
import java.util.List;

/**
 * create by hq 2020/03/18 17:58
 * 详情TIP查找
 */

public interface ScenicDetailTipDao {

    /**
     * 根据ID返回所有TIip信息
     * @param
     * @return
     */
    List<ScenicDetailTip> selectAllTipByScenic_Id(HashMap<String, Object> map);

}
