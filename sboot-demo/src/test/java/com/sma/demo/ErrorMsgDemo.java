package com.sma.demo;


import com.alibaba.fastjson.JSON;
import com.sma.demo.problem.ProblemId;
import com.sma.demo.problem.SmaTextRenderer;
import me.champeau.jdoctor.StandardSeverity;
import me.champeau.jdoctor.builders.ProblemBuilder;
import me.champeau.jdoctor.builders.internal.DefaultProblemBuilder;
import me.champeau.jdoctor.render.SimpleTextRenderer;
import net.minidev.json.JSONObject;

import java.text.MessageFormat;
import java.util.Arrays;


/**
 * @see <a href="https://github.com/melix/jdoctor"></a>
 */
public class ErrorMsgDemo {

    public static void main(String[] args) {
        String param = "01001axx*";

        DefaultProblemBuilder builder = (DefaultProblemBuilder) ProblemBuilder.newBuilder(ProblemId.P_SFA_001, // 错误码
                StandardSeverity.ERROR, // 异常级别
//                "com.sma.demo.ErrorMsgDemo.main(String[] args)[24]") // 上下文
                "{\"app\":\"sboot-demo\", \"component\": \"ErrorMsgDemo\", \"code\":\""+ProblemId.P_SFA_001.getName()+"\"}") // 上下文
                .withShortDescription(MessageFormat.format(ProblemId.P_SFA_001.getDesc(),param)) // 异常短描述
                .because("订单编号不能包含特殊字符")  // 原因描述
               // .withLongDescription("订单编号不能包含特殊字符：',.*=' 等等")  // 异常长描述
                .documentedAt("https://wiki.sma.com")
                .addSolution(s -> s.withShortDescription("检查订单编号是否只包含字母数字和下划线")); // 解决办法
        System.out.println(SmaTextRenderer.render(ProblemId.P_SFA_001.getName(),builder.get()));
    }
}
