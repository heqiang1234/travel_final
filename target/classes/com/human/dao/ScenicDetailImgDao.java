package com.human.dao;

import com.human.model.ScenicDetailImg;

import java.util.HashMap;
import java.util.List;

/**
 * create by hq 2020/03/18 17:51
 * ScenicDetailImgDao
 */
public interface ScenicDetailImgDao {

    /**
     * create by hq 2020/03/19 17:55
     * 根据ID详情页轮播图
     *
     */
    List<ScenicDetailImg> selectScenicDetailImgByScenic_Id(HashMap<String,Object> map);

    /**
     * create by hq 2020/03/19 17:55
     * 根据ID查看详细看点
     *
     */
    List<ScenicDetailImg> selectScenicDetailImgByScenic_Id_SP(HashMap<String,Object> map);

    /**
     * create by hq 2020/03/19 17:55
     * 首页轮播图
     *
     */
    List<ScenicDetailImg> getScenic_DetailImg();

    /**
     * create by hq 2020/03/19 17:55
     * 首页广告
     *
     */
    List<ScenicDetailImg> getScenic_DetailImgAd();

}
