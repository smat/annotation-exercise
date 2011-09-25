package com.github.smat.annotations.exercise2;

import com.github.smat.annotations.PrettyErrorMessages;
import com.github.smat.annotations.exercise2.domain.Board;
import com.github.smat.annotations.exercise2.domain.Player;
import com.github.smat.annotations.exercise2.exceptions.MalformedInputFromRuleException;
import com.github.smat.annotations.exercise2.exceptions.MalformedOutputFromRuleException;
import com.github.smat.annotations.exercise2.testclasses.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;

import static org.junit.Assert.assertEquals;

public class Exercise2Test {

    private Engine engine;

    @Before
    public void setup() {
        engine = new Engine(new Player(37), new Board(40));
    }

    @Test
    /**
     * Hints:
     * Check the content of the test-class.
     * Ignore the returnvalue of the function for now.
     */
    public void should_run_the_annotated_method_when_one_annotated_method_in_class() throws Exception {
        TestClassWithOneMethod testClass = new TestClassWithOneMethod();

        engine.checkRules(testClass);

        assertEquals("The function was not ran on the testclass", true, testClass.isRuleInvoked());
    }

    @Test(expected = MalformedOutputFromRuleException.class)
    public void should_throw_exception_when_method_does_not_return_an_integer() throws Exception {
        TestClassWithVoidReturnMethod testClass = new TestClassWithVoidReturnMethod();

        engine.checkRules(testClass);
    }

    @Test
    public void should_sum_the_result_of_each_rule_to_get_a_score() throws Exception {
        TestClassWithTwoMethods testClass = new TestClassWithTwoMethods();

        int result = engine.checkRules(testClass);

        assertEquals(42, result);
    }

    @Test
    public void should_not_run_disabled_rules() throws Exception {
        TestClassWithDisabledMethod testClass = new TestClassWithDisabledMethod();

        int result = engine.checkRules(testClass);

        assertEquals(42, result);
    }

    @Test(expected = MalformedInputFromRuleException.class)
    public void should_throw_exception_when_unknown_input_arguments_on_a_rule() throws Exception {
        TestClassWithUnknownInputArguments testClass = new TestClassWithUnknownInputArguments();

        engine.checkRules(testClass);
    }

    @Test
    public void should_support_player_as_input_argument_when_a_rule_needs_it() throws Exception {
        TestClassWithPlayerInputArgument testClass = new TestClassWithPlayerInputArgument();

        int result = engine.checkRules(testClass);

        assertEquals(37, result);
    }

    @Test
    public void should_support_player_and_board_as_argument_in_arbitrary_order_when_a_rule_need_it() throws Exception {
        TestClassWithPlayerAndBoardInput testClass = new TestClassWithPlayerAndBoardInput();

        int result = engine.checkRules(testClass);

        assertEquals(94, result);
    }

    
    @Rule
    public MethodRule prettyErrorMessages = new PrettyErrorMessages();
}
