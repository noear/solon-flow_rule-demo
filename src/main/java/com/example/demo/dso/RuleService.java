package com.example.demo.dso;

import com.example.demo.model.Calculation;
import org.noear.solon.annotation.Component;
import org.noear.solon.flow.Chain;
import org.noear.solon.flow.ChainContext;
import org.noear.solon.flow.FlowEngine;

@Component
public class RuleService {
    //调用Drools规则引擎实现个人所得税计算
    public Calculation calculate(Calculation calculation) throws Throwable {
        FlowEngine flowEngine = FlowEngine.newInstance();
        flowEngine.load(Chain.parseByUri("file:src/main/resources/flow/rule.yml"));

        //构建上下文
        ChainContext ctx = new ChainContext();
        ctx.put("cal", calculation);

        //执行规则
        flowEngine.eval("rule", ctx);

        //返回运行算后的
        return calculation;
    }
}
