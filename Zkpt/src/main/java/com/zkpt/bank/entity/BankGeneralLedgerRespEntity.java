package com.zkpt.bank.entity;

import com.zkpt.middleware.entity.ReplyParent;

/**
 * 对总帐响应包
 * 
 * @author zhaoqi
 *
 */
public class BankGeneralLedgerRespEntity implements ReplyParent, java.io.Serializable {
    private static final long serialVersionUID = 7310040045254151900L;

    @Override
    public String reply() {
        return null;
    }
}
