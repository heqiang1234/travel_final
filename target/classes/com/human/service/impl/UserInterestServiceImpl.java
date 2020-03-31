package com.human.service.impl;

import com.human.dao.ScenicDao;
import com.human.dao.UserInterestDao;
import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.model.UserInterest;
import com.human.service.UserInterestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserInterestServiceImpl implements UserInterestService {

    @Resource
    private UserInterestDao userInterestDao;

    @Resource
    private ScenicDao scenicDao;

    /**
     * 添加关注信息
     * @param user_spot_id
     * @param user_name
     * @param user_scenic_type
     * @param user_interest_time
     */
    @Override
    public void addUser_Interest(String user_spot_id, String user_name,String user_scenic_type, String user_interest_time) {
        HashMap<String,Object> mapp = new HashMap<String,Object>();
        mapp.put("user_spot_id",user_spot_id);
        mapp.put("user_name",user_name);
        mapp.put("user_scenic_type",user_scenic_type);
        mapp.put("user_interest_time",user_interest_time);
        userInterestDao.addUserInter(mapp);
    }

    /**
     * 修改关注的时间
     * @param interest_id
     * @param user_spot_id
     * @param user_name
     * @param user_scenic_type
     * @param user_interest_time
     */
    @Override
    public void updateUser_Interest(String interest_id,String user_spot_id, String user_name, String user_scenic_type, String user_interest_time) {
        HashMap<String,Object> mapp = new HashMap<String,Object>();
        mapp.put("user_interest_id",interest_id);
        mapp.put("user_spot_id",user_spot_id);
        mapp.put("user_name",user_name);
        mapp.put("user_scenic_type",user_scenic_type);
        mapp.put("user_interest_time",user_interest_time);
        userInterestDao.updateUserInter(mapp);
    }

    /**
     * 用户取消关注
     * @param user_interest_id
     * @return
     */
    @Override
    public int deleteUserInter(String user_interest_id) {
        HashMap<String,Object> mapp = new HashMap<String,Object>();
        mapp.put("user_interest_id",user_interest_id);
        return userInterestDao.deleteUserInter(mapp);
    }

    /**
     * 获取所有的关注景点信息
     * @param currentPage
     * @param pagesize
     * @param user_name
     * @return
     */
    @Override
    public PageBean<Scenic> selectAllUserInterByName(int currentPage, int pagesize, String user_name) {
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
        mappp.put("user_name",user_name);
        int totalCount = userInterestDao.getUserInterCount(mappp);
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
        map.put("user_name", user_name);
        //封装每页显示的数据
        List<UserInterest> lists = userInterestDao.selectAllUserInterByName(map);
        List<Scenic> ls = new ArrayList<>();
        for(int i=0;i<lists.size();i++)
        {    HashMap<String,Object> mapppp = new HashMap<String,Object>();
            mapppp.put("scenic_spot_id",lists.get(i).getUser_spot_id());
            Scenic sc= scenicDao.getScenicById(mapppp);
            sc.setScenic_crawltime(lists.get(i).getUser_interest_time());
            sc.setScenic_id(lists.get(i).getUser_interset_id());
            mappp.clear();
            ls.add(sc);
        }
        pageBean.setLists(ls);
        return pageBean;
    }

    /**
     * 查找是否已经关注
     * @param user_scenic_type
     * @param user_name
     * @param user_spot_id
     * @return
     */
    @Override
    public List<UserInterest> checkIsHave(String user_scenic_type,String user_name,String user_spot_id){
        HashMap<String,Object> map = new HashMap<String,Object>();

        map.put("user_scenic_type", user_scenic_type);
        map.put("user_name", user_name);
        map.put("user_spot_id", user_spot_id);
        //封装每页显示的数据
        List<UserInterest> lists = userInterestDao.checkIsHave(map);
        return lists;
    }

}
