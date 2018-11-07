package com.zkpt.bank.entity;

public enum BankCommand {
    COST_ARREARAGE("811", "查询欠费明细"), PAYMENT("821", "交易缴费"), USER_CHARGE("850", "用户冲帐"), GENERAL_LEDGER("600", "对总帐"), ESTABLISH_PROTOCOLT("640", "建立协议"), DELETE_PROTOCOL("650",
            "删除协议"), QUERY_PROTOCOL("660",
                    "查询协议"), QUERY_CARD_PROTOCOL("700", "查询卡对应协议"), QUERY_NUMBER("701", "根据名称查编号"), REQUEST_DEDUCTION("681", "请求批扣文件"), RETURN_DEDUCTION("680", "返回批扣结果");

    private String key;
    private String desc;

    private BankCommand(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    /**
     * 
     * 通过key查找bankReqCommand
     */
    public static BankCommand getEnumByKey(String key) {
        for (BankCommand bankCommand : BankCommand.values()) {
            if (key.equals(bankCommand.key)) {
                return bankCommand;
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
