package com.zkpt.bank.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.bank.service.IBankGeneralLedgerService;
import com.zkpt.middleware.service.IMwFactoryService;

@Service("bankGeneralLedgerService")
@Transactional
public class BankGeneralLedgerServiceImpl extends BankServiceImpl implements IBankGeneralLedgerService {
    private final static Logger logger = LoggerFactory.getLogger(BankGeneralLedgerServiceImpl.class);

    @Autowired
    private Environment env;

    @Autowired
    private IMwFactoryService mwFactoryService;

    @Override
    public boolean request(BankProtocalPackage bankProtocalPackage) throws Exception {
        // 1.连接银行端的ftp服务器
        // 2.本地缓存总对账文件
        // 3.关闭ftp连接
        // 4.连接天然气端的ftp
        // 5.上传总对账文件至天然气ftp服务器
        // 6.关闭ftp连接
        // 7.发送总对账请求

        return true;
    }

    @Override
    public String transBody(BankProtocalPackage packetBody) {
        return null;
    }

    @Override
    public boolean transLedgerSourceFileFormBankFtp() throws Exception {
        String ip = env.getProperty("middleware.bank.ftp.ip");
        String port = env.getProperty("middleware.bank.ftp.port");
        String user = env.getProperty("middleware.bank.ftp.user");
        String pwd = env.getProperty("middleware.bank.ftp.pwd");

        return true;
    }

    @Override
    public boolean transLedgerResultFileFromGasFtp() throws Exception {
        return true;
    }
}
