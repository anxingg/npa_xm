package com.zkpt.data.service;

import com.zkpt.data.entity.BankDevice;

public interface BankDeviceServiceI {
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
    int insert(BankDevice record);

    int insertSelective(BankDevice record);

    /**
     * 
     * @param id
     * @return
     */
    BankDevice selectByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BankDevice record);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(BankDevice record);
}
