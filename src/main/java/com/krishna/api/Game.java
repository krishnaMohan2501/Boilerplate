package com.krishna.api;

import com.krishna.Board;
import com.krishna.Coordinates;
import com.krishna.Layout;
import com.krishna.ShipType;
import com.krishna.ship.Cruiser;
import com.krishna.ship.Destroyer;
import com.krishna.ship.Ship;

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

    public void startGame(int size) {

        while(true){
            Coordinates c = new Coordinates(new Random().nextInt(size), new Random().nextInt(size));

            System.out.println(turn + " " + c.getX() + " " + c.getY());
            boolean isKilled = boards.get(turn % 2).destroy(c);
            if(isKilled){
                return;
            }else {
                turn++;
            }
        }

    }
}

