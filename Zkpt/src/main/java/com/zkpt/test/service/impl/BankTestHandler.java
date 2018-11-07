package com.zkpt.test.service.impl;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankTestHandler extends IoHandlerAdapter {
    private final static Logger LOGGER = LoggerFactory.getLogger(BankTestHandler.class);

    public BankTestHandler() {}

    @Override
    public void sessionOpened(IoSession session) {}
}
