package com.human.service;

import com.human.model.ScenicDetailTip;

import java.util.HashMap;
import java.util.List;

public interface ScenicDetailTipService {

    /**
     * 根据ID返回所有TIip信息
     * @param
     * @return
     */
    List<ScenicDetailTip> selectAllTipByScenic_Id(String S_SIGN,String S_ID);
}
