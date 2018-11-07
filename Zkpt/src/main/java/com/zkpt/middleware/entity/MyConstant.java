package com.zkpt.middleware.entity;

public abstract class MyConstant {
    public final static String SPLIT = "|";
    public final static String SPLIT1 = "\\|";
    public final static String SPLIT2 = "$";
    public final static String SPLIT3 = "\\$";

    // -------------------------------------------------Redis所用的常量------------------------------------------------
    public final static String REDIS_MIDDLEWARE_CHANNEL = "mc";
    public final static long REDIS_DEFAULT_TIMETOLIVE = 600L;
    public final static String REDIS_USER_ARREAR_PREFIX = "userArrear:";

    // -------------------------------------------------错误消息提示------------------------------------------------
    public final static String ERROR_PAY_001 = "存储失效!";
    public final static String ERROR_PAY_002 = "缴费月份不对,无欠款!";
    public final static String ERROR_PAY_003 = "缴费金额不对!";
    public final static String ERROR_COM_001 = "连接天然气服务器失败,查询失败!";

    // -------------------------------------------欠费查询失败Gas的错误提示-------------------------------------------
    /**
     * 错误消息样本:用户无欠费 </br>
     * 返回状态码:0111
     */
    public final static String GC_0101_FAIL_MESSAGE_001 = "用户无欠费";
    /**
     * 错误消息样本:用户不存在 </br>
     * 返回状态码:0110
     */
    public final static String GC_0101_FAIL_MESSAGE_002 = "用户不存在";
    /**
     * 错误消息样本:数据格式错误 </br>
     * 返回状态码:0121
     */
    public final static String GC_0101_FAIL_MESSAGE_003 = "数据格式错误";

    // -------------------------------------------缴费操作失败Gas的错误提示-------------------------------------------
    /**
     * 错误消息样本:ORA-20001: {用户100100170012<2018-08-25>抄表欠费已缴，无法重新销帐！} </br>
     * 返回状态码:0002
     */
    public final static String GC_0102_FAIL_MESSAGE_001 = "抄表欠费已缴，无法重新销帐";

    /**
     * 错误消息样本:ORA-20001: 实缴金额不足，销账失败！ </br>
     * 返回状态码:0002
     */
    public final static String GC_0102_FAIL_MESSAGE_002 = "实缴金额不足，销账失败";

    /**
     * 错误消息样本:ORA-01403: no data found </br>
     * 返回状态码:0110
     */
    public final static String GC_0102_FAIL_MESSAGE_003 = "no data found";
    /**
     * 错误消息样本:帐户不存在 </br>
     * 返回状态码:0002
     */
    public final static String GC_0102_FAIL_MESSAGE_004 = "帐户不存在";

    // -------------------------------------------冲账操作失败Gas的错误提示-------------------------------------------
    /**
     * 返回状态码:0130
     */
    public final static String GC_0103_FAIL_MESSAGE_001 = "冲帐失败只能冲当天帐";

    /**
     * 返回状态码:0002
     */
    public final static String GC_0103_FAIL_MESSAGE_002 = "冲帐失败";
}
