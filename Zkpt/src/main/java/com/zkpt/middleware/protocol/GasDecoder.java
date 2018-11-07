package com.zkpt.middleware.protocol;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Date;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zkpt.gas.entity.GasCommand;
import com.zkpt.gas.entity.GasPacketHeadEntity;
import com.zkpt.gas.entity.GasProtocalPackage;
import com.zkpt.util.ProtocolTxTUtil;

/**
 * 解码器
 * 
 * @author sunpei
 *
 */
public class GasDecoder extends CumulativeProtocolDecoder {
    private final static Logger logger = LoggerFactory.getLogger(GasDecoder.class);
    public final static int PACKAGE_HEAD_LENGTH = 51;
    private Charset charset;

    public GasDecoder() {}

    public GasDecoder(Charset charset) {
        this.charset = charset;
    }

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
        in.order(ByteOrder.LITTLE_ENDIAN);
        if (in.remaining() < 4) { // 这里很关键，网上很多代码都没有这句，是用来当拆包时候剩余长度小于4的时候的保护，不加就出错咯
            return false;
        }

        if (in.remaining() > 1) {
            int length = in.remaining();
            if (length < PACKAGE_HEAD_LENGTH) { // 包头没有读取完毕
                return false;
            } else {
                in.mark();
                byte[] messageBytes = new byte[length];
                in.get(messageBytes, 0, length); // 读取整个报文
                byte[] messageBodyLengthBtyes = new byte[] {messageBytes[45], messageBytes[46], messageBytes[47], messageBytes[48], messageBytes[49]}; // 包体长度
                String slength = ProtocolTxTUtil.byteArrayToStr(messageBodyLengthBtyes, charset).replaceFirst("^0*", "");
                int messageBodyLength = 0;
                if (!"".equals(slength))
                    messageBodyLength = Integer.parseInt(slength);
                if (length < PACKAGE_HEAD_LENGTH + messageBodyLength) { // 数据没有接受完毕
                    in.reset();
                    return false;
                } else { // 接受完毕了数据
                    String mesage = ProtocolTxTUtil.byteArrayToStr(messageBytes, charset);
                    GasProtocalPackage gasProtocalPackage = new GasProtocalPackage();

                    GasPacketHeadEntity gasData = new GasPacketHeadEntity();

                    char[] requestId = ProtocolTxTUtil.strToCharArray(mesage.substring(0, 4));// 包头
                    char[] bankNo = ProtocolTxTUtil.strToCharArray(mesage.substring(4, 7));// 缴费点代码
                    char[] bankDeviceNo = ProtocolTxTUtil.strToCharArray(mesage.substring(7, 17));// 缴费点密码
                    char[] bankBizSn = ProtocolTxTUtil.strToCharArray(mesage.substring(17, 27));// 备用
                    char[] timeStamp = ProtocolTxTUtil.strToCharArray(mesage.substring(27, 41));// 交易方式
                    char[] respondState = ProtocolTxTUtil.strToCharArray(mesage.substring(41, 45));// 交易流水号
                    char[] DataLength = ProtocolTxTUtil.strToCharArray(mesage.substring(45, 50));// 包体长度字节数
                    char[] isNextPacket = ProtocolTxTUtil.strToCharArray(mesage.substring(50, 51));// 包头结束符

                    gasData.setRequestId(requestId);
                    gasData.setBankNo(bankNo);
                    gasData.setBankDeviceNo(bankDeviceNo);
                    gasData.setBankBizSn(bankBizSn);
                    gasData.setTimeStamp(timeStamp);
                    gasData.setRespondState(respondState);
                    gasData.setDataLength(DataLength);
                    gasData.setIsNextPacket(isNextPacket);

                    gasData.setRequestId_s(mesage.substring(0, 4));
                    gasData.setBankNo_s(mesage.substring(4, 7));
                    gasData.setBankDeviceNo_s(mesage.substring(7, 17));
                    gasData.setBankBizSn_s(mesage.substring(17, 27));
                    gasData.setTimeStamp_s(mesage.substring(27, 41));
                    gasData.setRespondState_s(mesage.substring(41, 45));
                    gasData.setDataLength_s(mesage.substring(45, 50));
                    gasData.setIsNextPacket_s(mesage.substring(50, 51));

                    // 重组gasProtocalPackage
                    gasProtocalPackage.setPacketHead(gasData);
                    gasProtocalPackage.setPacketBody(mesage.substring(PACKAGE_HEAD_LENGTH));
                    gasProtocalPackage.setEchoTime(new Date());
                    GasCommand type = GasCommand.getEnumByKey(mesage.substring(0, 4));
                    switch (type) {
                    case YHQFQK_COMM:
                        gasProtocalPackage.setGasCommand(GasCommand.YHQFQK_COMM);
                        break;
                    case QFJN_COMM:
                        gasProtocalPackage.setGasCommand(GasCommand.QFJN_COMM);
                        break;
                    case QXJF_COMM:
                        gasProtocalPackage.setGasCommand(GasCommand.QXJF_COMM);
                        break;
                    case DZRZ_COMM:
                        gasProtocalPackage.setGasCommand(GasCommand.DZRZ_COMM);
                        break;
                    default:
                        break;
                    }
                    out.write(gasProtocalPackage);
                    if (in.remaining() > 0) {// 如果读取内容后还粘了包，就让父类再重读 一次，进行下一次解析
                        return true;
                    }
                    return false;
                }
            }

        }

        return false;
    }

}
