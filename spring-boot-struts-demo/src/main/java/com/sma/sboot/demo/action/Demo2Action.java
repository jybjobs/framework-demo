package com.sma.sboot.demo.action;


import com.opensymphony.xwork2.ActionSupport;
import com.sma.sboot.demo.service.DemoService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import static com.opensymphony.xwork2.Action.SUCCESS;


/**
 * struts demo
 */

@Controller("demoAction")
//@ParentPackage("struts-default")
@Namespace("/demo")
public class Demo2Action {
    private static final String PAGES_ROOT = "/WEB-INF";


    @Autowired
    private DemoService demoService;

    @Action(value = "test",results  = {@Result(name = SUCCESS, location ="/index.jsp")})
    public String getTest(){
        System.out.println("I'm just a test message.");
      //  demoService.test();
        return SUCCESS;
    }
}
