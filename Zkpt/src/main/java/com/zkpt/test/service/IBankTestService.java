package com.zkpt.test.service;

public interface IBankTestService {
    /**
     * 模拟测试欠费查询
     * 
     * @param bankNo
     * @param user
     * @param month
     * @return
     * @throws Exception
     */
    public boolean queryArrears(String bankNo, String user, String month) throws Exception;


    /**
     * 模拟测试交易缴费
     * 
     * @param bankNo
     * @param user
     * @param money
     * @param month
     * @return
     * @throws Exception
     */
    public boolean payment(String bankNo, String user, double money, String month) throws Exception;

    /**
     * 模拟测试用户销账
     * 
     * @param bankNo
     * @param user
     * @param serNo
     * @return
     * @throws Exception
     */
    public boolean userCharge(String bankNo, String user, String serNo) throws Exception;

    /**
     * 消费消息
     * 
     * @return
     */
    public void consumeMes(String mes);
}
