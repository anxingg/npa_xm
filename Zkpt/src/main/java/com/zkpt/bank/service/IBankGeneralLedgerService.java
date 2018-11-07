package com.zkpt.bank.service;

/**
 * 对总帐（600）
 * 
 * @author zhaoqi
 *
 */
public interface IBankGeneralLedgerService extends IBankService {
    /**
     * 从银行Ftp传输总对账文件至天然气Ftp
     * 
     * @return
     * @throws Exception
     */
    public boolean transLedgerSourceFileFormBankFtp() throws Exception;

    /**
     * 从天然气Ftp回传总对账文件至银行Ftp
     * 
     * @return
     * @throws Exception
     */
    public boolean transLedgerResultFileFromGasFtp() throws Exception;
}
