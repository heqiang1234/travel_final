package com.human.service;

import com.human.model.PageBean;
import com.human.model.Scenic;

import java.util.HashMap;
import java.util.List;

/**
 * create by hq2020/03/18
 * scenicService层
 */

public interface ScenicService {

    //查询所有景点信息
    List<Scenic> selectAllScenicInfo();

    //查询景点数量
    int ScenicCountAll();

    //查询某地区景点数量
    int ScenicCount(String ScenicAddress);

    //根据type查询景点数量
    int selectScenicByType(String S_id,String S_name);


    /**
     * 根据ID获取景点
     * @param
     * @return
     */
    Scenic getScenicById(String scenic_id);


    /**
     * 分页操作，调用findByPage limit分页方法
     * @param
     * @return
     */
    PageBean<Scenic> findScenicByPage(int currentPage,int pagesize,String type);

    /**
     * 分页查找搜索框的输入
     * @param cur
     * @param pag
     * @param Search_Id
     * @param Search_Name
     * @return
     */
    PageBean<Scenic> SearchScenicByType(int cur,int pag,String Search_Id,String Search_Name);

    /**
     * 分页操作，findByPageByAddress limit分页方法
     * @param map
     * @return
     */
    PageBean<Scenic> findScenicByPageByAddress(HashMap<String, Object> map);

    /**
     * 返回推荐景点的数量
     * @param
     * @return
     */
    int selectPostAICount(String user_name);


    /**
     * 分页操作，GetPostAIScenic limit分页方法
     * @param
     * @return
     */
    PageBean<Scenic> GetPostAIScenic(int cur,int pag,String user_name);

}
