package com.zkpt.data.service;

import com.zkpt.data.entity.BankDeviceBehavior;

public interface BankDeviceBehaviorServiceI {
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
    int insert(BankDeviceBehavior record);

    int insertSelective(BankDeviceBehavior record);

    /**
     * 
     * @param id
     * @return
     */
    BankDeviceBehavior selectByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BankDeviceBehavior record);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(BankDeviceBehavior record);
}
