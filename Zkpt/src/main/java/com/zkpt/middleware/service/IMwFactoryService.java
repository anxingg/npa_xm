package com.zkpt.middleware.service;

import java.io.IOException;

import org.apache.mina.core.session.IoSession;

import com.zkpt.bank.entity.BankProtocalPackage;

public interface IMwFactoryService {
    /**
     * 建立服务器监听
     * 
     * @return
     * @throws IOException
     */
    public boolean createMWServer() throws IOException;

    /**
     * 建立客户端连接
     * 
     * @return
     * @throws IOException
     */
    public IoSession createMWClient() throws IOException;

    /**
     * 获取服务端的IoSession
     * 
     * @param key
     * @return
     */
    public IoSession getServerSession(BankProtocalPackage key);
}
