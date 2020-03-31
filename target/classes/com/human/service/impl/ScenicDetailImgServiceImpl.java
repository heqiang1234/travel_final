package com.human.service.impl;

import com.human.dao.ScenicDetailImgDao;
import com.human.model.ScenicDetailImg;
import com.human.service.ScenicDetailImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ScenicDetailImgServiceImpl  implements ScenicDetailImgService {

    @Resource
    private ScenicDetailImgDao scenicDetailImgDao;

    /**
     * create by hq 2020/03/18 17:55
     * 根据ID详情页轮播图
     *
     */
    @Override
    public List<ScenicDetailImg> selectScenicDetailImgByScenic_Id(String S_ID) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("S_ID",S_ID);
        return scenicDetailImgDao.selectScenicDetailImgByScenic_Id(map);
    }

    /**
     * create by hq 2020/03/18 17:55
     * 根据ID查看详细看点
     *
     */
    @Override
    public List<ScenicDetailImg> selectScenicDetailImgByScenic_Id_SP(String S_ID) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("S_ID",S_ID);
        return scenicDetailImgDao.selectScenicDetailImgByScenic_Id_SP(map);
    }

    /**
     * 轮播图
     * @return
     */
    @Override
    public List<ScenicDetailImg> getScenic_DetailImg() {
        return scenicDetailImgDao.getScenic_DetailImg();
    }

    /**
     * 广告图片
     * @return
     */
    @Override
    public List<ScenicDetailImg> getScenic_DetailImgAd() {
        return scenicDetailImgDao.getScenic_DetailImgAd();
    }

}
