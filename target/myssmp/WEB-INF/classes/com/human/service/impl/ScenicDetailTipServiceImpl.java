package com.human.service.impl;

import com.human.dao.ScenicDetailTipDao;
import com.human.model.ScenicDetailTip;
import com.human.service.ScenicDetailImgService;
import com.human.service.ScenicDetailTipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ScenicDetailTipServiceImpl implements ScenicDetailTipService {

    @Resource
    private ScenicDetailTipDao scenicDetailTipDao;

    @Override
    public List<ScenicDetailTip> selectAllTipByScenic_Id(String S_SIGN, String S_ID) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("S_SIGN",S_SIGN);
        map.put("S_ID",S_ID);
        return scenicDetailTipDao.selectAllTipByScenic_Id(map);
    }
}
