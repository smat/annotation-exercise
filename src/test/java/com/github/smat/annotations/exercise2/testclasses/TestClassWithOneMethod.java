package com.github.smat.annotations.exercise2.testclasses;

import com.github.smat.annotations.exercise2.annotations.EngineRule;

public class TestClassWithOneMethod {
    private boolean invoked = false;

    @EngineRule
    public Integer doRule() {
        invoked = true;
        return 42;
    }

    public boolean isRuleInvoked() {
        return invoked;
    }
}
