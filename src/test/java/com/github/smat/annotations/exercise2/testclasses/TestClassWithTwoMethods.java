package com.github.smat.annotations.exercise2.testclasses;

import com.github.smat.annotations.exercise2.annotations.EngineRule;

public class TestClassWithTwoMethods {
    @EngineRule
    public int doRuleOne() {
        return 12;
    }

    @EngineRule
    public Integer doRuleTwo() {
        return 30;
    }
}
