package com.zkpt.gas.entity;

/**
 * 查询气费欠费RespondState
 * 
 * @author 赵琦
 *
 */
public enum GasRespState {
    SUCESS("0000", "查询成功"), FAIL_DETAIL("0002", "查询失败（具体见返回内容）"), NOARREARS("0110", "没有欠费信息"), FAIL("0111", "查询失败"), MOREARREARS("0112",
            "欠费月份太多，需要到营业所进行查询缴费"), FAIL_PAYMENT("0120", "缴费失败（具体信息见返回内容）"), FORMAL_ERROR("0121", "数据格式错误"), ONLY_TODAY("0130", "冲帐失败只能冲当天帐");
    private String key;
    private String desc;

    private GasRespState(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    /**
     * 
     * 通过key查找GasCostArrearageResState
     */
    public static GasRespState getEnumByKey(String key) {
        for (GasRespState gasCostArrearageResState : GasRespState.values()) {
            if (key.equals(gasCostArrearageResState.key)) {
                return gasCostArrearageResState;
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
