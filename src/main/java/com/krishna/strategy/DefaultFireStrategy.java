package com.krishna.strategy;

import com.krishna.Board;
import com.krishna.Coordinates;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public Object[]  fire(List<Board> boards, int turn) {
        Set<Coordinates> targets  = boards.get(turn % 2).getCoordinates();
        Object[] targetArray = targets.toArray();

        Set<Coordinates> randomTargets = new HashSet<>();
        randomTargets.add(new Coordinates(new Random().nextInt(50), new Random().nextInt(50)));
        Object[] myRandomTarget = targets.toArray();

        return ArrayUtils.addAll(targetArray, myRandomTarget);


    }
}
