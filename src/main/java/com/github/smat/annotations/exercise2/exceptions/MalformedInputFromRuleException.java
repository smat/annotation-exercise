package com.github.smat.annotations.exercise2.exceptions;

public class MalformedInputFromRuleException extends RuntimeException {
    public MalformedInputFromRuleException(Class<?> parameter) {
        super("Unknown input for rule: " + parameter.getCanonicalName());
    }
}
