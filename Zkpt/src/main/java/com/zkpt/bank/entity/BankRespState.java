package com.zkpt.bank.entity;

public enum BankRespState {

    TRADE_SUCESS("000", "交易成功"), USER_NOEXIST("001", "该用户不存在"), SPECIAL_USER("002", "特殊用户不交费"), RECORD_LOCK("003", "记录已锁（如已转非实时方式处理）"), ALREADY_PAID("004", "已缴费"), AMOUNTDIFFER(
            "005", "金额不符"), NON_EXISTENT("006", "交易不存在"), ILLEGAL_TRADING("008", "交易不合法"), OTHER("009", "其他"), NO_ARREARS("010", "无欠费信息"), CANNOT_PRINT("011",
                    "未交费不能打印发票"), TRADE_FAIL("012", "交易失败"), PACKET_ERROR("020", "数据包格式错"), WRONG_OPERATION("021", "数据库操作错"), OTHER_ERROR("999", "其他错误"), FILE_DOESNOT_EXIST("030",
                            "文件不存在"), AGREEMENT_ESTABLISHED("032", "协议已经建立"), AGREEMENT_DOESNOT_EXIST("033", "协议不存在"), PROTOCOL_FAILURE("034", "修改协议失败");

    private String key;
    private String desc;

    private BankRespState(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    /**
     * 
     * 通过key查找BankCostArrearageReqState
     */
    public static BankRespState getEnumByKey(String key) {
        for (BankRespState bankCostArrearageReqState : BankRespState.values()) {
            if (key.equals(bankCostArrearageReqState.key)) {
                return bankCostArrearageReqState;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
