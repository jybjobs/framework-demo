package com.sma.demo.controller;


import com.sma.demo.mbean.SelfMBean;
import com.sma.demo.mbean.SelfMetrics;
import com.sma.demo.trans.TransApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class TransController {

    @Autowired
    private TransApi  transApi;

    @Autowired
    private SelfMetrics selfMetrics;

    @Autowired
    private SelfMBean selfMBean;

    @GetMapping(path = "/trans")
    @ResponseBody
    public String trans(String query){
        selfMetrics.timer();
        selfMBean.timer();
        return transApi.getTransResult(query, "auto", "en");
    }
}
