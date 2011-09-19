package com.github.smat.annotations;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class PrettyErrorMessages implements MethodRule {
    public Statement apply(Statement base, FrameworkMethod method, Object target) {
        return new ExpectedExceptionStatement(base);
    }

    private class ExpectedExceptionStatement extends Statement {
        private Statement base;

        public ExpectedExceptionStatement(Statement base) {
            this.base = base;
        }

        @Override
        public void evaluate() throws Throwable {
            try {
                base.evaluate();
            }
            catch (ClassNotFoundException e) {
                throw new AssertionError("Could not find class " + e.getMessage() + ". Try creating it.");
            }
            catch (Throwable e) {
                if (e.getCause() != null && e.getCause().getCause() != null && e.getCause().getCause() instanceof AssertionError) {
                    throw e.getCause().getCause();
                }
                else {
                    throw e;
                }
            }
        }
    }
}
