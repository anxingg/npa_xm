package com.zkpt.middleware.service;

import java.io.IOException;

import com.zkpt.bank.entity.BankProtocalPackage;
import com.zkpt.gas.entity.GasProtocalPackage;

/**
 * 
 * @author 赵琦
 *
 */
public interface IMwTransportService {
    /**
     * 
     * @param bankProtocalPackage
     * @return
     * @throws IOException
     */
    public boolean trans_in(BankProtocalPackage bankProtocalPackage) throws IOException;

    /**
     * 
     * @param gasProtocalPackage
     * @param serverSessionKey
     * @return
     * @throws IOException
     */
    public boolean trans_out(GasProtocalPackage gasProtocalPackage, BankProtocalPackage serverSessionKey) throws IOException;

}
