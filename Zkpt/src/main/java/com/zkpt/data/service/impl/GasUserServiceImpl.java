package com.zkpt.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.data.dao.BankDeviceBehaviorMapper;
import com.zkpt.data.dao.BankDeviceMapper;
import com.zkpt.data.dao.GasUserBehaviorMapper;
import com.zkpt.data.dao.GasUserCostMapper;
import com.zkpt.data.dao.GasUserMapper;
import com.zkpt.data.dao.OperationMapper;
import com.zkpt.data.entity.BankDevice;
import com.zkpt.data.entity.BankDeviceBehavior;
import com.zkpt.data.entity.GasUser;
import com.zkpt.data.entity.GasUserBehavior;
import com.zkpt.data.entity.GasUserCost;
import com.zkpt.data.entity.Operation;
import com.zkpt.data.service.GasUserServiceI;

@Service("gasUserService")
@Transactional
public class GasUserServiceImpl implements GasUserServiceI {
    @Resource
    private GasUserMapper gasUserDao;
    
    @Resource
    private OperationMapper operationDao;
    
    @Resource
    private BankDeviceMapper bankDeviceDao;
    
    @Resource
    private BankDeviceBehaviorMapper bankDeviceBehaviorDao;
    
    @Resource
    private GasUserBehaviorMapper gasUserBehaviorDao;
    
    @Resource
    private GasUserCostMapper gasUserCostDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return gasUserDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GasUser record) {
        return gasUserDao.insert(record);
    }

    @Override
    public int insertSelective(GasUser record) {
        return gasUserDao.insertSelective(record);
    }

    @Override
    public GasUser selectByPrimaryKey(Integer id) {
        return gasUserDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GasUser record) {
        return gasUserDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GasUser record) {
        return gasUserDao.updateByPrimaryKey(record);
    }

	@Override
	public GasUser selectByUserNo(String userNo) {
		return gasUserDao.selectByUserNo(userNo);
	}

	@Override
	public boolean isOperation(GasUser gasUser, BankDevice bankDevice, BankDeviceBehavior bankDeviceBehavior,
			GasUserBehavior gasUserBehavior, GasUserCost gasUserCost, Operation operation) {
		GasUser user = gasUserDao.selectByUserNo(gasUser.getUserNo());
		if ("null".equals(String.valueOf(user))) {
			gasUserDao.insert(gasUser);
		}
		operationDao.insert(operation);
		BankDevice bank = bankDeviceDao.selectByBankNo(bankDevice.getBankNo());
		if ("null".equals(String.valueOf(bank))) {
			bankDeviceDao.insert(bankDevice);
			bank = bankDeviceDao.selectByBankNo(bankDevice.getBankNo());
		}
		bankDeviceBehavior.setOpertionId(operation.getId());
		bankDeviceBehavior.setBankDeviceId(bank.getId());
		bankDeviceBehaviorDao.insert(bankDeviceBehavior);
		gasUserBehavior.setOpertionId(operation.getId());
		gasUserBehavior.setBankDeviceId(bank.getId());
		gasUserBehaviorDao.insert(gasUserBehavior);
		gasUserCostDao.insert(gasUserCost);
		return false;
	}
}
