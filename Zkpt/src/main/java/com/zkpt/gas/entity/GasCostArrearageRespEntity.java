package com.zkpt.gas.entity;

import java.util.List;

/**
 * 查询气费欠费信息(响应包)
 * 
 * @author 赵琦
 *
 */
public class GasCostArrearageRespEntity implements java.io.Serializable {
    private static final long serialVersionUID = -4813325417601061785L;

    private char[] totalCost; // 总应缴费用
    private char[] arrearsMonths; // 欠费月数
    private List<GasCostArrearageRespDetailEntity> list; // 欠费明细

    private double totalCost_s;
    private int arrearsMonths_s;


    public char[] getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(char[] totalCost) {
        this.totalCost = totalCost;
    }

    public char[] getArrearsMonths() {
        return arrearsMonths;
    }

    public void setArrearsMonths(char[] arrearsMonths) {
        this.arrearsMonths = arrearsMonths;
    }

    public List<GasCostArrearageRespDetailEntity> getList() {
        return list;
    }

    public void setList(List<GasCostArrearageRespDetailEntity> list) {
        this.list = list;
    }

    public double getTotalCost_s() {
        return totalCost_s;
    }

    public void setTotalCost_s(double totalCost_s) {
        this.totalCost_s = totalCost_s;
    }

    public int getArrearsMonths_s() {
        return arrearsMonths_s;
    }

    public void setArrearsMonths_s(int arrearsMonths_s) {
        this.arrearsMonths_s = arrearsMonths_s;
    }
}
