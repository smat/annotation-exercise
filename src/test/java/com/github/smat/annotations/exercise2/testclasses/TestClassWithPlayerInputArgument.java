package com.github.smat.annotations.exercise2.testclasses;

import com.github.smat.annotations.exercise2.annotations.EngineRule;
import com.github.smat.annotations.exercise2.domain.Player;

public class TestClassWithPlayerInputArgument {
    @EngineRule
    public int addPlayerHandicap(Player player) {
        return player.getHandicap();
    }
}
