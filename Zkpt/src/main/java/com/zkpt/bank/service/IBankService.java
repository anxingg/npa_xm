package com.zkpt.bank.service;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.gas.entity.GasProtocalPackage;

/**
 * 银行服务接口
 * 
 * @author 赵琦
 *
 */
public interface IBankService {
    /**
     * 请求 请求天然气服务
     * 
     * @param bankProtocalPackage
     * @return
     * @throws Exception
     */
    public boolean request(BankProtocalPackage bankProtocalPackage) throws Exception;


    /**
     * 响应 获取银行数据进行处理
     * 
     * @param gasProtocalPackage
     * @param serverSessionKey
     * @return
     * @throws Exception
     */
    public boolean response(GasProtocalPackage gasProtocalPackage, BankProtocalPackage serverSessionKey) throws Exception;

    /**
     * 写日志
     * 
     * @return
     * @throws Exception
     */
    public boolean loged() throws Exception;

    /**
     * 写数据库
     * 
     * @return
     * @throws Exception
     */
    public boolean persistenced() throws Exception;

    /**
     * 转燃气银行通讯协议
     * 
     * @param bankProtocalPackage
     * @param body
     * @return
     */
    public GasProtocalPackage protocalTransToGas(BankProtocalPackage bankProtocalPackage, String body);

    /**
     * 转换成gas的请求包
     * 
     * @param packetBody
     * @return
     */
    public String transBody(BankProtocalPackage packetBody);

    /**
     * 错误反馈
     * 
     * @param errorMsg 错误消息
     * @param respondState 响应码
     * @param bankProtocalPackage 协议包
     * @param splitCount 拼接字符串的数量
     * @throws Exception
     */
    public void errorWrite(String respondState, String errorMsg, BankProtocalPackage bankProtocalPackage, int splitCount) throws Exception;
}
