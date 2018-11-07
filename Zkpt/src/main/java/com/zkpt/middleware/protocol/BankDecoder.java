package com.zkpt.middleware.protocol;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zkpt.bank.entity.BankCommand;
import com.zkpt.bank.entity.BankPacketHeadEntity;
import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.util.ProtocolTxTUtil;

/**
 * 解码器
 * 
 * @author sunpei
 *
 */
public class BankDecoder extends CumulativeProtocolDecoder {
    private final static Logger logger = LoggerFactory.getLogger(BankDecoder.class);
    public final static int PACKAGE_HEAD_LENGTH = 33;
    private Charset charset;

    public BankDecoder() {}

    public BankDecoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        if (in.remaining() >= PACKAGE_HEAD_LENGTH) {
            in.mark();
            byte[] headBytes = new byte[PACKAGE_HEAD_LENGTH];
            in.get(headBytes); // 读取报头
            byte[] bodyLengthBtyes = new byte[] {headBytes[28], headBytes[29], headBytes[30], headBytes[31]}; // 包体的数据长度
            int bodyLength = Integer.parseInt(ProtocolTxTUtil.byteArrayToStr(bodyLengthBtyes, charset).replaceFirst("^0*", ""));

            if (in.remaining() < bodyLength) { // 数据包没有接受完毕
                in.reset();
                return false;
            }

            byte[] bodyBtyes = new byte[bodyLength];
            in.get(bodyBtyes); // 读取数据包
            String head = ProtocolTxTUtil.byteArrayToStr(headBytes, charset);
            String body = ProtocolTxTUtil.byteArrayToStr(bodyBtyes, charset);
            BankProtocalPackage bankProtocalPackage = new BankProtocalPackage();
            BankPacketHeadEntity bankData = new BankPacketHeadEntity();

            // 封装报头
            bankData.setFixedNumber(ProtocolTxTUtil.strToCharArray(head.substring(0, 2)));// 包头
            bankData.setPaymentCode(ProtocolTxTUtil.strToCharArray(head.substring(2, 6)));// 缴费点代码
            bankData.setPaymentPointPassword(ProtocolTxTUtil.strToCharArray(head.substring(6, 11)));// 缴费点密码
            bankData.setSpare(ProtocolTxTUtil.strToCharArray(head.substring(11, 12)));// 备用
            bankData.setTransactionMode(ProtocolTxTUtil.strToCharArray(head.substring(12, 14)));// 交易方式
            bankData.setTransactionFlow(ProtocolTxTUtil.strToCharArray(head.substring(14, 28)));// 交易流水号
            bankData.setDataLength(ProtocolTxTUtil.strToCharArray(head.substring(28, 32)));// 包体长度字节数
            bankData.setBaotouEnd(ProtocolTxTUtil.strToCharArray(head.substring(32, 33)));// 包头结束符
            bankData.setFixedNumber_s(head.substring(0, 2));
            bankData.setPaymentCode_s(head.substring(2, 6));
            bankData.setPaymentPointPassword_s(head.substring(6, 11));
            bankData.setSpare_s(head.substring(11, 12));
            bankData.setTransactionMode_s(head.substring(12, 14));
            bankData.setTransactionFlow_s(head.substring(14, 28));
            bankData.setDataLength_s(head.substring(28, 32));
            bankData.setBaotouEnd_s(head.substring(32, 33));

            // 重组bankProtocalPackage
            bankProtocalPackage.setPacketHead(bankData);
            bankProtocalPackage.setPacketBody(body);
            BankCommand type = BankCommand.getEnumByKey(body.substring(0, 3));
            switch (type) {
            case COST_ARREARAGE:
                bankProtocalPackage.setBankCommand(BankCommand.COST_ARREARAGE);
                break;
            case PAYMENT:
                bankProtocalPackage.setBankCommand(BankCommand.PAYMENT);
                break;
            case USER_CHARGE:
                bankProtocalPackage.setBankCommand(BankCommand.USER_CHARGE);
                break;
            case GENERAL_LEDGER:
                bankProtocalPackage.setBankCommand(BankCommand.GENERAL_LEDGER);
                break;
            case ESTABLISH_PROTOCOLT:
                bankProtocalPackage.setBankCommand(BankCommand.ESTABLISH_PROTOCOLT);
                break;
            case DELETE_PROTOCOL:
                bankProtocalPackage.setBankCommand(BankCommand.DELETE_PROTOCOL);
                break;
            case QUERY_PROTOCOL:
                bankProtocalPackage.setBankCommand(BankCommand.QUERY_PROTOCOL);
                break;
            case QUERY_CARD_PROTOCOL:
                bankProtocalPackage.setBankCommand(BankCommand.QUERY_CARD_PROTOCOL);
                break;
            case QUERY_NUMBER:
                bankProtocalPackage.setBankCommand(BankCommand.QUERY_NUMBER);
                break;
            case REQUEST_DEDUCTION:
                bankProtocalPackage.setBankCommand(BankCommand.REQUEST_DEDUCTION);
                break;
            case RETURN_DEDUCTION:
                bankProtocalPackage.setBankCommand(BankCommand.RETURN_DEDUCTION);
                break;
            default:
                break;
            }
            bankProtocalPackage.setServerSessionKey(session.getId());
            InetSocketAddress inetSocketAddress = (InetSocketAddress) session.getRemoteAddress();
            InetAddress address = inetSocketAddress.getAddress();
            bankProtocalPackage.setClientIp(address.getHostAddress());
            bankProtocalPackage.setClientPort(inetSocketAddress.getPort());
            bankProtocalPackage.setSentTime(new Date());
            out.write(bankProtocalPackage);
            if (in.remaining() > 0) {// 如果读取内容后还粘了包，就让父类再重读 一次，进行下一次解析
                return true;
            }
            return true;
        }

        return false;
    }
}
