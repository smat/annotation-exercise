package com.github.smat.annotations.exercise2;

import com.github.smat.annotations.exercise2.domain.Board;
import com.github.smat.annotations.exercise2.domain.Player;

public class Engine {
    private Player player;
    private Board board;

    public Engine(Player player, Board board) {
        this.player = player;
        this.board = board;
    }

    public int checkRules(Object rules) throws Exception {
        return 0;
    }
}