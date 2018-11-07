package com.zkpt.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.data.dao.GasUserCostMapper;
import com.zkpt.data.entity.GasUserCost;
import com.zkpt.data.service.GasUserCostServiceI;

@Service("gasUserCostService")
@Transactional
public class GasUserCostServiceImpl implements GasUserCostServiceI {
    @Resource
    private GasUserCostMapper gasUserCostDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return gasUserCostDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GasUserCost record) {
        return gasUserCostDao.insert(record);
    }

    @Override
    public int insertSelective(GasUserCost record) {
        return gasUserCostDao.insertSelective(record);
    }

    @Override
    public GasUserCost selectByPrimaryKey(Integer id) {
        return gasUserCostDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GasUserCost record) {
        return gasUserCostDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GasUserCost record) {
        return gasUserCostDao.updateByPrimaryKey(record);
    }
}
