package com.zkpt.middleware.protocol;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankCodecFactory implements ProtocolCodecFactory {
    private final static Logger logger = LoggerFactory.getLogger(BankCodecFactory.class);
    private final BankDecoder decoder;
    private final BankEncoder encoder;

    // 构造
    public BankCodecFactory() {
        decoder = new BankDecoder();
        encoder = new BankEncoder();
    }

    public BankCodecFactory(String ecoding) {
        decoder = new BankDecoder(Charset.forName(ecoding));
        encoder = new BankEncoder(Charset.forName(ecoding));
    }

    @Override
    public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
        return decoder;
    }

    @Override
    public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
        return encoder;
    }
}
