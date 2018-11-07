package com.zkpt.bank.entity;

import com.zkpt.middleware.entity.MyConstant;
import com.zkpt.util.ProtocolTxTUtil;

/**
 * 查询欠费明细请求包,命令字:811
 * 
 * @author 孙培
 *
 */
public class BankCostArrearageReqEntity extends BankParentReqEntity implements java.io.Serializable {
    private static final long serialVersionUID = 6960034104978224405L;
    private char[] transactionCode; // 交易码
    private char[] userNo; // 用户编号
    private char[] month; // 费用月份，缺省为000000，表示全额缴费；其它值为YYYYMM
    private char[] queryFlag; // 查询标志，1：查询最近24个月欠费情况

    private String transactionCode_s;
    private String userNo_s;
    private String month_s;
    private String queryFlag_s;

    public char[] getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(char[] transactionCode) {
        this.transactionCode = transactionCode;
    }

    public char[] getUserNo() {
        return userNo;
    }

    public void setUserNo(char[] userNo) {
        this.userNo = userNo;
    }

    public char[] getMonth() {
        return month;
    }

    public void setMonth(char[] month) {
        this.month = month;
    }

    public char[] getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(char[] queryFlag) {
        this.queryFlag = queryFlag;
    }

    public String getTransactionCode_s() {
        return transactionCode_s;
    }

    public void setTransactionCode_s(String transactionCode_s) {
        this.transactionCode_s = transactionCode_s;
    }

    public String getUserNo_s() {
        return userNo_s;
    }

    public void setUserNo_s(String userNo_s) {
        this.userNo_s = userNo_s;
    }

    public String getMonth_s() {
        return month_s;
    }

    public void setMonth_s(String month_s) {
        this.month_s = month_s;
    }

    public String getQueryFlag_s() {
        return queryFlag_s;
    }

    public void setQueryFlag_s(String queryFlag_s) {
        this.queryFlag_s = queryFlag_s;
    }

    public static BankParentReqEntity packaging(String packageBody) {
        BankCostArrearageReqEntity entity = new BankCostArrearageReqEntity();
        String[] packageBodys = packageBody.split(MyConstant.SPLIT1);
        entity.setTransactionCode_s(packageBodys[0]);
        entity.setUserNo_s(packageBodys[1]);
        entity.setMonth_s(packageBodys[2]);
        entity.setQueryFlag_s(packageBodys[3]);
        entity.setTransactionCode(ProtocolTxTUtil.strToCharArray(entity.getTransactionCode_s()));
        entity.setUserNo(ProtocolTxTUtil.strToCharArray(entity.getUserNo_s()));
        entity.setMonth(ProtocolTxTUtil.strToCharArray(entity.getMonth_s()));
        entity.setQueryFlag(ProtocolTxTUtil.strToCharArray(entity.getQueryFlag_s()));
        return entity;
    }
}
