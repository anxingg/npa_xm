package com.zkpt.data.service;

import com.zkpt.data.entity.BankDevice;
import com.zkpt.data.entity.BankDeviceBehavior;
import com.zkpt.data.entity.GasUser;
import com.zkpt.data.entity.GasUserBehavior;
import com.zkpt.data.entity.GasUserCost;
import com.zkpt.data.entity.Operation;

public interface GasUserServiceI {
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
    int insert(GasUser record);

    int insertSelective(GasUser record);

    /**
     * 
     * @param id
     * @return
     */
    GasUser selectByPrimaryKey(Integer id);
    
    /**
     * 
     * @param userNo
     * @return
     */
    GasUser selectByUserNo(String userNo);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(GasUser record);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(GasUser record);
    /**
     * 
     * @param gasUser
     * @param bankDevice
     * @param bankDeviceBehavior
     * @param gasUserBehavior
     * @param gasUserCost
     * @param operation
     * @return
     */
    boolean isOperation(GasUser gasUser, BankDevice bankDevice, BankDeviceBehavior bankDeviceBehavior, GasUserBehavior gasUserBehavior,
    		GasUserCost gasUserCost, Operation operation);
}
