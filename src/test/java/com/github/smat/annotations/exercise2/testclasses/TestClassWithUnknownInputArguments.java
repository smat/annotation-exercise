package com.github.smat.annotations.exercise2.testclasses;

import com.github.smat.annotations.exercise2.annotations.EngineRule;

import java.math.BigDecimal;

import static org.junit.Assert.fail;

public class TestClassWithUnknownInputArguments {
    @EngineRule
    public int unknownInputArguments(BigDecimal unknown) {
        fail("Should not call this function");
        return 0;
    }
}
