package com.zkpt.data.service;

import com.zkpt.data.entity.Operation;

public interface OperationServiceI {
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
    int insert(Operation record);

    int insertSelective(Operation record);

    /**
     * 
     * @param id
     * @return
     */
    Operation selectByPrimaryKey(Integer id);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Operation record);

    /**
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(Operation record);
}
