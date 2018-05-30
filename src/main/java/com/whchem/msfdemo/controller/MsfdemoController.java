package com.whchem.msfdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RefreshScope
@RestController
@Api
public class MsfdemoController {
    
    private Logger logger = LoggerFactory.getLogger(MsfdemoController.class);
// *************************
    @ApiOperation(value = "测试接口1", notes = "swagger样例1")
    @GetMapping("/")
    public String printServiceA() {
    	logger.info("写入日志");
    	return "Hello World";
    }
}
