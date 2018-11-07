package com.zkpt.data.service;

import com.zkpt.data.entity.GasUserCost;

public interface GasUserCostServiceI {
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
    int insert(GasUserCost record);

    int insertSelective(GasUserCost record);

    /**
     * 
     * @param id
     * @return
     */
    GasUserCost selectByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(GasUserCost record);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(GasUserCost record);
}
