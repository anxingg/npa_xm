package com.zkpt.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.data.dao.BankDeviceBehaviorMapper;
import com.zkpt.data.entity.BankDeviceBehavior;
import com.zkpt.data.service.BankDeviceBehaviorServiceI;

@Service("bankDeviceBehaviorService")
@Transactional
public class BankDeviceBehaviorServiceImpl implements BankDeviceBehaviorServiceI {
    @Resource
    private BankDeviceBehaviorMapper bankDeviceBehaviorDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bankDeviceBehaviorDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BankDeviceBehavior record) {
        return bankDeviceBehaviorDao.insert(record);
    }

    @Override
    public int insertSelective(BankDeviceBehavior record) {
        return bankDeviceBehaviorDao.insertSelective(record);
    }

    @Override
    public BankDeviceBehavior selectByPrimaryKey(Integer id) {
        return bankDeviceBehaviorDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BankDeviceBehavior record) {
        return bankDeviceBehaviorDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BankDeviceBehavior record) {
        return bankDeviceBehaviorDao.updateByPrimaryKey(record);
    }
}
