package com.zkpt.gas.entity;

/**
 * 用户冲帐(响应包)
 * 
 * @author 赵琦
 *
 */
public class GasUserChargeRespEntity implements java.io.Serializable {
    private static final long serialVersionUID = -6493874383898883122L;

    private char[] msg;
    private String msg_s;

    public char[] getMsg() {
        return msg;
    }

    public void setMsg(char[] msg) {
        this.msg = msg;
    }

    public String getMsg_s() {
        return msg_s;
    }

    public void setMsg_s(String msg_s) {
        this.msg_s = msg_s;
    }
}
