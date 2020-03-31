package com.human.service.impl;

import com.google.inject.internal.util.$AsynchronousComputationException;
import com.human.dao.ScenicDao;
import com.human.model.PageBean;
import com.human.model.Scenic;
import com.human.service.ScenicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class ScenicServiceImpl  implements ScenicService {

    @Resource
    private ScenicDao scenicDao;

    @Override
    public List<Scenic> selectAllScenicInfo() {

        System.out.println("hello commmmm");
        return scenicDao.selectAllScenicInfo();
    }

    @Override
    public int ScenicCountAll() {
        return 0;
    }

    @Override
    public int ScenicCount(String ScenicAddress) {
        return 0;
    }

    /**
     * 根据类型查询数据数量
     * @param S_ID
     * @param S_Name
     * @return
     */
    @Override
    public int selectScenicByType(String S_ID, String S_Name) {
        HashMap<String,Object> map_count = new HashMap<String,Object>();
        map_count.put("S_ID",S_ID);
        map_count.put("S_Name",S_Name);
        int Count = scenicDao.selectScenicByType(map_count);
        return  Count;
    }

    /**
     * 根据ID获取景点数据
     * @param Scenic_id
     * @return
     */
    @Override
    public Scenic getScenicById(String Scenic_id) {
        HashMap<String,Object> scenicById_count = new HashMap<String,Object>();
        scenicById_count.put("scenic_spot_id",Scenic_id);
        return scenicDao.getScenicById(scenicById_count);
    }

    @Override
    public PageBean<Scenic> findScenicByPage(int currentPage,int pagesize,String type){
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
    int totalCount = selectScenicByType("Hot",type);
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
    //封装每页显示的数据
    List<Scenic> lists = scenicDao.findScenicByPage(map);
        pageBean.setLists(lists);
        return pageBean;
    }

    @Override
    public PageBean<Scenic> SearchScenicByType(int currentPage, int pagesize, String Search_Id, String Search_Name) {
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
        int totalCount = selectScenicByType(Search_Id,Search_Name);
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
        map.put("S_ID", Search_Id);
        map.put("S_Name", Search_Name);
        //封装每页显示的数据
        List<Scenic> lists = scenicDao.SearchScenicByType(map);
        pageBean.setLists(lists);
        return pageBean;
    }

    @Override
    public PageBean<Scenic> findScenicByPageByAddress(HashMap<String, Object> map) {
        return null;
    }

    @Override
    public int selectPostAICount(String user_name) {
        HashMap<String,Object> map_count = new HashMap<String,Object>();
        map_count.put("user_name",user_name);
        int Count = scenicDao.selectPostAICount(map_count);
        return  Count;
    }

    @Override
    public PageBean<Scenic> GetPostAIScenic(int currentPage, int pagesize, String user_name) {
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
        int totalCount = scenicDao.selectPostAICount(mappp);
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
        List<Scenic> lists = scenicDao.GetPostAIScenic(map);
        pageBean.setLists(lists);
        return pageBean;
    }
}
