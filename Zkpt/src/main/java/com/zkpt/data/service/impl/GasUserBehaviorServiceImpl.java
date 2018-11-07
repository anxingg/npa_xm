package com.zkpt.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.data.dao.GasUserBehaviorMapper;
import com.zkpt.data.entity.GasUserBehavior;
import com.zkpt.data.service.GasUserBehaviorServiceI;

@Service("gasUserBehaviorService")
@Transactional
public class GasUserBehaviorServiceImpl implements GasUserBehaviorServiceI {
    @Resource
    private GasUserBehaviorMapper gasUserBehaviorDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return gasUserBehaviorDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GasUserBehavior record) {
        return gasUserBehaviorDao.insert(record);
    }

    @Override
    public int insertSelective(GasUserBehavior record) {
        return gasUserBehaviorDao.insertSelective(record);
    }

    @Override
    public GasUserBehavior selectByPrimaryKey(Integer id) {
        return gasUserBehaviorDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GasUserBehavior record) {
        return gasUserBehaviorDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GasUserBehavior record) {
        return gasUserBehaviorDao.updateByPrimaryKey(record);
    }
}
