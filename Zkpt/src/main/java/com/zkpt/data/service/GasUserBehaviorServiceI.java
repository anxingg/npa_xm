package com.zkpt.data.service;

import com.zkpt.data.entity.GasUserBehavior;

public interface GasUserBehaviorServiceI {
    /**
     * 
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return
     */
    int insert(GasUserBehavior record);

    int insertSelective(GasUserBehavior record);

    /**
     * 
     * @param id
     * @return
     */
    GasUserBehavior selectByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(GasUserBehavior record);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(GasUserBehavior record);
}
