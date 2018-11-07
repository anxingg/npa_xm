package jp.chainage.webapp.cc.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.chainage.webapp.cc.service.CcCacheReloadServiceI;

@Service("ccCacheReloadService")
@Transactional
public class CcCacheReloadServiceImpl extends CommonServiceImpl implements CcCacheReloadServiceI {
    private static final Logger logger = LoggerFactory.getLogger(CcCacheReloadServiceImpl.class);

    @Override
    public boolean exchanges() throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean assets() throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean symbols() throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean xx1() throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

}
