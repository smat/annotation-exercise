package com.github.smat.annotations.exercise2.testclasses;

import com.github.smat.annotations.exercise2.annotations.EngineRule;

import static org.junit.Assert.fail;

public class TestClassWithVoidReturnMethod {
    @EngineRule
    public void doRule() {
        fail("Should not run this rule");
    }
}
