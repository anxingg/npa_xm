package com.zkpt.middleware.protocol;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zkpt.gas.entity.GasProtocalPackage;

/**
 * 编码器
 * 
 * @author sunpei
 *
 */
public class GasEncoder extends ProtocolEncoderAdapter {
    private final static Logger logger = LoggerFactory.getLogger(GasEncoder.class);
    private Charset charset;

    public GasEncoder() {}

    public GasEncoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        GasProtocalPackage protocalPackage = (GasProtocalPackage) message;
        // 根据报文长度开辟空间
        IoBuffer buff = IoBuffer.allocate(51 + Integer.valueOf(protocalPackage.getPacketHead().getDataLength_s()));
        // 设置为可自动扩展空间
        buff.setAutoExpand(true);
        CharsetEncoder ce=charset.newEncoder();
        // 将报文中的信息添加到buff中
        if (protocalPackage.getPacketHead() != null) {
            buff.putString(protocalPackage.getPacketHead().getRequestId_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getBankNo_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getBankDeviceNo_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getBankBizSn_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getTimeStamp_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getRespondState_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getDataLength_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getIsNextPacket_s(),ce);
            buff.putString(protocalPackage.getPacketBody(),ce);
        }
        buff.flip();
        // 将报文发送出去
        out.write(buff);
    }
}
