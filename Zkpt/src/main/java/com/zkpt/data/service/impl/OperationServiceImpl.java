package com.zkpt.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.data.dao.OperationMapper;
import com.zkpt.data.entity.Operation;
import com.zkpt.data.service.OperationServiceI;

@Service("operationService")
@Transactional
public class OperationServiceImpl implements OperationServiceI {
    @Resource
    private OperationMapper operationDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return operationDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Operation record) {
        return operationDao.insert(record);
    }

    @Override
    public int insertSelective(Operation record) {
        return operationDao.insertSelective(record);
    }

    @Override
    public Operation selectByPrimaryKey(Integer id) {
        return operationDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Operation record) {
        return operationDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Operation record) {
        return operationDao.updateByPrimaryKey(record);
    }
}
