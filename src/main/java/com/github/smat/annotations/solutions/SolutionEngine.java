package com.github.smat.annotations.solutions;

import com.github.smat.annotations.exercise2.annotations.EngineRule;
import com.github.smat.annotations.exercise2.domain.Board;
import com.github.smat.annotations.exercise2.domain.Player;
import com.github.smat.annotations.exercise2.exceptions.MalformedInputFromRuleException;
import com.github.smat.annotations.exercise2.exceptions.MalformedOutputFromRuleException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class SolutionEngine {
    private Player player;
    private Board board;

    public SolutionEngine(Player player, Board board) {
        this.player = player;
        this.board = board;
    }

    public int checkRules(Object rules) throws InvocationTargetException, IllegalAccessException {
        int total = 0;
        for (Method method : rules.getClass().getMethods()) {
            if (method.isAnnotationPresent(EngineRule.class)) {
                if (!method.getReturnType().equals(Integer.class) && !method.getReturnType().equals(Integer.TYPE)) {
                    throw new MalformedOutputFromRuleException(method);
                }
                EngineRule annotation = method.getAnnotation(EngineRule.class);
                if (!annotation.disabled()) {
                    ArrayList<Object> arguments = new ArrayList<Object>();
                    for (Class<?> parameter : method.getParameterTypes()) {
                        if (parameter.equals(Player.class)) {
                            arguments.add(player);
                        }
                        else if (parameter.equals(Board.class)) {
                            arguments.add(board);
                        }
                        else {
                            throw new MalformedInputFromRuleException(parameter);
                        }
                    }
                    total += (Integer) method.invoke(rules, arguments.toArray());
                }
            }
        }
        return total;
    }
}
