package com.human.service;

import com.human.model.ScenicDetail;
import com.human.model.ScenicDetailImg;

import java.util.HashMap;
import java.util.List;

public interface ScenicDetailImgService {


    /**
     * create by hq 2020/03/19 17:55
     * 根据ID详情页轮播图
     *
     */
    List<ScenicDetailImg> selectScenicDetailImgByScenic_Id(String S_ID);

    /**
     * create by hq 2020/03/19 17:55
     * 根据ID查看详细看点
     *
     */
    List<ScenicDetailImg> selectScenicDetailImgByScenic_Id_SP(String S_ID);

    /**
     * create by hq 2020/03/18 17:55
     * 首页轮播图
     *
     */
    List<ScenicDetailImg> getScenic_DetailImg();

    /**
     * create by hq 2020/03/18 17:55
     * 首页广告
     *
     */
    List<ScenicDetailImg> getScenic_DetailImgAd();





}
