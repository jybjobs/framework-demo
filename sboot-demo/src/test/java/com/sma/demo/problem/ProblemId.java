package com.sma.demo.problem;

public enum ProblemId {
        P_SFA_001("P-SFA-001","订单号格式错误: {0}"),
        B_SFA_011("B-SFA-011","订单创建失败"),
        S_SFA_021("S-SFA-021","订单系统异常");
    private String name;
    private String desc;

    ProblemId(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

}
