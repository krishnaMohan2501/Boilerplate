package com.krishna.api;

import com.krishna.Board;
import com.krishna.Coordinates;
import com.krishna.Layout;
import com.krishna.ShipType;
import com.krishna.ship.Cruiser;
import com.krishna.ship.Destroyer;
import com.krishna.ship.Ship;
import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class Game {
    List<Board> boards;
    int turn = 0;
    Map<Integer,String> shipIdMapping;



    Layout getLayout() {
        return ( new Random().nextBoolean() ? Layout.HORIZONTAL : Layout.VERTICAL);
    }


    public Game(){
        shipIdMapping = new HashMap<>();
        shipIdMapping.put(1,"Destroyer");
        shipIdMapping.put(2,"Cruiser");
    }
    public void initGame(int n){
        boards = new ArrayList<Board>();
        boards.add(new Board(n, "player1"));
        boards.add(new Board(n, "player2"));

    }

    public void addShip(int id, int shipSize, int p1x, int p1y, int p2x, int p2y){

        String shipname = shipIdMapping.get(id);
        if(shipname.equals("Destroyer")){
            this.boards.get(0).layShip(new Destroyer(new Coordinates(p1x, p1y), getLayout()),shipSize );
            this.boards.get(1).layShip(new Destroyer(new Coordinates(p2x, p2y), getLayout()), shipSize );
        }else if(shipname.equals("Cruiser")) {
            this.boards.get(0).layShip(new Cruiser(new Coordinates(p1x, p1y), getLayout()), shipSize);
            this.boards.get(1).layShip(new Cruiser(new Coordinates(p2x, p2y), getLayout()), shipSize);
        }


    }

    public void startGame() {
        Set<Coordinates> targets  = boards.get(turn % 2).getCoordinates();
        Object[] targetArray = targets.toArray();

        Set<Coordinates> randomTargets = new HashSet<>();
        randomTargets.add(new Coordinates(new Random().nextInt(50), new Random().nextInt(50)));
        Object[] myRandomTarget = targets.toArray();

        Object[] randomizedTarger = ArrayUtils.addAll(targetArray, myRandomTarget);

        while(true){

            int randomTargetIndex  = new Random().nextInt(randomizedTarger.length);

            Coordinates c = (Coordinates) randomizedTarger[randomTargetIndex];
            boolean isKilled = boards.get(turn % 2).destroy(c);
//            boards.get(turn % 2).
            if(isKilled){
                if(turn % 2==0){
                    System.out.println("Player1 turn: missile fired at ("+ c.getX() + "," + c.getY() + "). Hit" );
                }else{
                    System.out.println("Player2 turn: missile fired at ("+ c.getX() + "," + c.getY() + "). Hit" );
                }
            }else {
                if(turn % 2==0){
                    System.out.println("Player1 turn: missile fired at ("+ c.getX() + "," + c.getY() + "). MISS" );
                }else{
                    System.out.println("Player2 turn: missile fired at ("+ c.getX() + "," + c.getY() + "). MISS" );
                }
            }

            if(boards.get(turn % 2).getCoordinates().size()==0){
                String player="";
                if(turn % 2==0){
                    player= "Player1";
                }else{
                    player = "Player2";
                }
                System.out.println("Game over: " + player + ": Won");
                return;
            }

            turn++;
        }

    }
}

