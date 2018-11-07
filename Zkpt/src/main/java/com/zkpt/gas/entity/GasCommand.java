package com.zkpt.gas.entity;

/**
 * 命令字（主命令+子命令字）
 * 
 * @author 赵琦
 *
 */
public enum GasCommand {
    YHQFQK_COMM("0101", "用户气费欠款"), QFJN_COMM("0102", "气费缴纳（销账）"), QXJF_COMM("0103", "取消缴费信息（冲账）"), DKYHLB_COMM("0104", "发送代扣用户列表"), DKHYQK_COMM("0105", "请求代扣用户欠款信息"), PKJG_COMM(
            "0106", "发送批扣结果"), JFLS_COMM("0107", "查询缴费流水"), DYJFFP_COMM("0108", "打印缴费发票"), DZRZ_COMM("0109", "发送对账日志"), XBBRJ_COMM("0002", "发送新版本软件"), CSSZ_COMM("0003", "发送参数设置");
    private String key;
    private String desc;

    private GasCommand(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    /**
     * 
     * 通过key查找GasCommandTypeCons
     */
    public static GasCommand getEnumByKey(String key) {
        for (GasCommand gasCommandType : GasCommand.values()) {
            if (key.equals(gasCommandType.key)) {
                return gasCommandType;
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
