package com.github.smat.annotations.exercise2.testclasses;

import com.github.smat.annotations.exercise2.annotations.EngineRule;

public class TestClassWithDisabledMethod {
    @EngineRule
    public int enabledRule() {
        return 42;
    }

    @EngineRule(disabled = true)
    public int disabledRule() {
        return 100;
    }
}
