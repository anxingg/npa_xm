package com.zkpt.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkpt.test.service.IBankTestService;

@Controller
@RequestMapping("banktest")
public class BankTestController {
    private final static Logger logger = LoggerFactory.getLogger(BankTestController.class);
    @Autowired
    private IBankTestService bankTestService;


    @RequestMapping("index")
    public String index(Model model) {
        return "bankdSimulation";
    }

    @RequestMapping("queryArrears")
    @ResponseBody
    public String queryArrears(String bankNo, String user, String month, HttpServletRequest request, HttpServletResponse response) {
        try {
            bankTestService.queryArrears(bankNo, user, month);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("payment")
    @ResponseBody
    public String payment(String bankNo, String user, double money, String month, HttpServletRequest request, HttpServletResponse response) {
        try {
            bankTestService.payment(bankNo, user, money, month);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("userCharge")
    @ResponseBody
    public String userCharge(String bankNo, String user, String serNo, HttpServletRequest request, HttpServletResponse response) {
        try {
            bankTestService.userCharge(bankNo, user, serNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
