package com.zkpt.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.data.dao.BankDeviceMapper;
import com.zkpt.data.entity.BankDevice;
import com.zkpt.data.service.BankDeviceServiceI;

@Service("bankDeviceService")
@Transactional
public class BankDeviceServiceImpl implements BankDeviceServiceI {
    @Resource
    private BankDeviceMapper bankDeviceDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bankDeviceDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BankDevice record) {
        return bankDeviceDao.insert(record);
    }

    @Override
    public int insertSelective(BankDevice record) {
        return bankDeviceDao.insertSelective(record);
    }

    @Override
    public BankDevice selectByPrimaryKey(Integer id) {
        return bankDeviceDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BankDevice record) {
        return bankDeviceDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BankDevice record) {
        return bankDeviceDao.updateByPrimaryKey(record);
    }
}
