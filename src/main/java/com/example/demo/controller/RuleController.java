package com.example.demo.controller;

import com.example.demo.dso.RuleService;
import com.example.demo.model.Calculation;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;

@Mapping("rule")
@Controller
public class RuleController {
    @Inject
    RuleService ruleService;

    @Mapping("calculate")
    public Calculation calculate(double wage) throws Throwable {
        Calculation calculation = new Calculation();
        calculation.setWage(wage);
        calculation = ruleService.calculate(calculation);
        System.out.println(calculation);
        return calculation;
    }
}
