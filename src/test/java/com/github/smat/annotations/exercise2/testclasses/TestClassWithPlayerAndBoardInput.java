package com.github.smat.annotations.exercise2.testclasses;

import com.github.smat.annotations.exercise2.annotations.EngineRule;
import com.github.smat.annotations.exercise2.domain.Board;
import com.github.smat.annotations.exercise2.domain.Player;

public class TestClassWithPlayerAndBoardInput {
    @EngineRule
    public int playerHandicapMinusHalfBoardHandicap(Player player, Board board) {
        return player.getHandicap() - board.getHandicap() / 2;
    }

    @EngineRule
    public int boardHandicapPlusPlayerHandicap(Board board, Player player) {
        return board.getHandicap() + player.getHandicap();
    }
}
