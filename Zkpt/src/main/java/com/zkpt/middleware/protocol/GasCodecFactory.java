package com.zkpt.middleware.protocol;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GasCodecFactory implements ProtocolCodecFactory {
    private final static Logger logger = LoggerFactory.getLogger(GasCodecFactory.class);
    private final GasDecoder decoder;
    private final GasEncoder encoder;

    // 构造
    public GasCodecFactory() {
        decoder = new GasDecoder();
        encoder = new GasEncoder();
    }

    public GasCodecFactory(String ecoding) {
        decoder = new GasDecoder(Charset.forName(ecoding));
        encoder = new GasEncoder(Charset.forName(ecoding));
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
