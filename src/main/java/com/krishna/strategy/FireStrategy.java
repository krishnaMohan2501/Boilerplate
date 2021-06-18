package com.krishna.strategy;

import com.krishna.Board;

import java.util.List;

public interface FireStrategy {
    Object[] fire(List<Board> boards, int turn);
}
