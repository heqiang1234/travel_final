package com.human.service.impl;

import com.human.dao.ScenicDetailDao;
import com.human.model.ScenicDetail;
import com.human.service.ScenicDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ScenicDetailServiceImpl implements ScenicDetailService {

    @Resource
    private ScenicDetailDao scenicDetailDao;

    @Override
    public ScenicDetail getScenic_DetailByScenic_Id(String S_ID) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("S_ID",S_ID);
        return scenicDetailDao.getScenic_DetailByScenic_Id(map);
    }

}
