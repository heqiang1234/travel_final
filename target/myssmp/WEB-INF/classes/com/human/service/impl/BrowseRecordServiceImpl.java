package com.human.service.impl;

import com.human.dao.BrowseRecordDao;
import com.human.dao.ScenicDao;
import com.human.model.BrowseRecord;
import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.service.BrowseRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BrowseRecordServiceImpl implements BrowseRecordService {

    @Resource
    private BrowseRecordDao browseRecordDao;

    @Resource
    private ScenicDao scenicDao;

    @Override
    public void addBrowseRecord(String user_spot_id, String record_username, String record_time) {
        HashMap<String,Object> mapp = new HashMap<String,Object>();
        mapp.put("scenic_spot_id",user_spot_id);
        mapp.put("record_username",record_username);
        mapp.put("record_time",record_time);
        browseRecordDao.addBrowseRecord(mapp);
    }

    @Override
    public int deleteBrowseRecord(String record_id) {
        HashMap<String,Object> mapp = new HashMap<String,Object>();
        mapp.put("record_id",record_id);
        return browseRecordDao.deleteBrowseRecord(mapp);
    }

    @Override
    public int deleteAllBrowseRecord(String record_username) {
        HashMap<String,Object> mapp = new HashMap<String,Object>();
        mapp.put("record_username",record_username);
        return browseRecordDao.deleteAllBrowseRecord(mapp);
    }

    @Override
    public PageBean<Scenic> selectAllBrowseRecordByName(int currentPage, int pagesize, String user_name) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Scenic> pageBean = new PageBean<Scenic>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //判断是否有前一页,然后进行赋值操作，回显前台
        if(currentPage>1)
            pageBean.setPreviousPage(true);
        else
            pageBean.setPreviousPage(false);

        //每页显示的数据
        int pageSize=pagesize;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        HashMap<String,Object> mappp = new HashMap<String,Object>();
        mappp.put("record_username",user_name);
        int totalCount = browseRecordDao.getBrowseRecordCount(mappp);
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        if(currentPage<=num.intValue()-1)
            pageBean.setAfterPage(true);
        else
            pageBean.setAfterPage(false);
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("record_username", user_name);
        //封装每页显示的数据
        List<BrowseRecord> lists = browseRecordDao.selectAllBrowseRecordByName(map);
        List<Scenic> ls = new ArrayList<>();
        for(int i=0;i<lists.size();i++)
        {    HashMap<String,Object> mapppp = new HashMap<String,Object>();
            mapppp.put("scenic_spot_id",lists.get(i).getScenic_spot_id());
            Scenic sc= scenicDao.getScenicById(mapppp);
            sc.setScenic_crawltime(lists.get(i).getRecord_time());
            sc.setScenic_id(lists.get(i).getRecord_id());
            mappp.clear();
            ls.add(sc);
        }
        pageBean.setLists(ls);
        return pageBean;
    }

}
