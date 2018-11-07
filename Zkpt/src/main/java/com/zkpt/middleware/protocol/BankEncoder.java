package com.zkpt.middleware.protocol;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zkpt.bank.entity.BankProtocalPackage;

/**
 * 编码器： 在Mina
 * 中编写编码器可以实现ProtocolEncoder，其中有encode()、dispose()两个方法需要实现。这里的dispose()方法用于在销毁编码器时释放关联的资源，
 * 由于这个方法一般我们并不关心，所以通常我们直接继承适配器ProtocolEncoderAdapter
 * 
 * @author sunpei
 *
 */
public class BankEncoder extends ProtocolEncoderAdapter {
    private final static Logger logger = LoggerFactory.getLogger(BankEncoder.class);
    private Charset charset;

    public BankEncoder() {}

    public BankEncoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        BankProtocalPackage protocalPackage = (BankProtocalPackage) message;
        // 根据报文长度开辟空间
        IoBuffer buff = IoBuffer.allocate(33 + Integer.valueOf(protocalPackage.getPacketHead().getDataLength_s()));
        // 设置为可自动扩展空间
        buff.setAutoExpand(true);
        CharsetEncoder ce=charset.newEncoder();
        // 将报文中的信息添加到buff中
        if (protocalPackage.getPacketHead() != null) {
            buff.putString(protocalPackage.getPacketHead().getFixedNumber_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getPaymentCode_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getPaymentPointPassword_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getSpare_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getTransactionMode_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getTransactionFlow_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getDataLength_s(),ce);
            buff.putString(protocalPackage.getPacketHead().getBaotouEnd_s(),ce);
            buff.putString(protocalPackage.getPacketBody(),ce);
        }
        buff.flip();
        // 将报文发送出去
        out.write(buff);
    }
}
