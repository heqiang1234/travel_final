package com.human.dao;

import com.human.model.Scenic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 *
 * 2020/03/18 17:52 create by HQ
 * 景点DAO
 *
 */
@Repository
public interface ScenicDao {

    //查询所有景点信息
     List<Scenic> selectAllScenicInfo();

     //查询景点数量
     int ScenicCountAll();

     //查询某地区景点数量String ScenicAddress
     int ScenicCount();

    /**
     * 根据ID获取景点
     * @param map
     * @return
     */
     Scenic getScenicById(HashMap<String,Object> map);

    /**
     * 返回相应的数量
     * @param map
     * @return
     */
    int selectScenicByType(HashMap<String,Object> map);


    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    List<Scenic> findScenicByPage(HashMap<String, Object> map);

    /**
     * 分页操作，findByPageByAddress limit分页方法
     * @param map
     * @return
     */
     List<Scenic> findScenicByPageByAddress(HashMap<String, Object> map);


    /**
     * 分页操作，SearchScenicByType limit分页方法
     * @param map
     * @return
     */
    List<Scenic> SearchScenicByType(HashMap<String, Object> map);


    /**
     * 返回推荐景点的数量
     * @param map
     * @return
     */
    int selectPostAICount(HashMap<String,Object> map);


    /**
     * 分页操作，GetPostAIScenic limit分页方法
     * @param map
     * @return
     */
    List<Scenic> GetPostAIScenic(HashMap<String, Object> map);

}
