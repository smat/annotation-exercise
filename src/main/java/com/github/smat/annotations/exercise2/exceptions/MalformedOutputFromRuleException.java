package com.github.smat.annotations.exercise2.exceptions;

import java.lang.reflect.Method;

public class MalformedOutputFromRuleException extends RuntimeException {
    public MalformedOutputFromRuleException(Method method) {
        super("Malformed rule on method " + method.toGenericString() +
              ". All methods must return an int or java.lang.Integer, but this method returns " + method.getReturnType().getCanonicalName());
    }
}
