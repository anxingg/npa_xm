package com.zkpt.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zkpt.demo.service.DemoServiceI;

@Service("demoService")
public class DemoServiceImpl implements DemoServiceI {
    private final static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
}
