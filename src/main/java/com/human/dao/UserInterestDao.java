package com.human.dao;

import com.human.model.UserInterest;

import java.util.HashMap;
import java.util.List;

public interface UserInterestDao {

    /**
     * 添加关注景点
     * @param map
     * @return
     */
    void addUserInter (HashMap<String, Object> map);

    /**
     * 删除关注景点
     * @param map
     * @return
     */
    int deleteUserInter (HashMap<String, Object> map);



    void updateUserInter(HashMap<String, Object> map);


    /**
     * 得到景点数量
     * @param map
     * @return
     */
    int getUserInterCount (HashMap<String, Object> map);


    /**
     * 查看关注景点
     * @param map
     * @return
     */
    List<UserInterest> selectAllUserInterByName (HashMap<String, Object> map);



    /**
     * 查看是否存在
     * @param map
     * @return
     */
    List<UserInterest> checkIsHave (HashMap<String, Object> map);
}
