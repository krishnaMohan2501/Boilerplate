package com.krishna;

import com.krishna.ship.Ship;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Board {
    private String playerName;
    private int size;

    @Getter
    // we will be adding ships coordinate of cells which are occupied by ships.
    private Set<Coordinates> coordinates = new HashSet<Coordinates>();

    public Board(int size, String playerName) {
        this.size = size;
        this.playerName = playerName;
    }

    public int getSize(){
        return size;
    }
    public boolean layShip(Ship ship, int shipSize) {
        Coordinates c = ship.getCoordinates();

        if (c.getX() < 0 || c.getX() > size) return false;
        if (c.getY() < 0 || c.getY() > size) return false;

        if (ship.getLayout() == Layout.HORIZONTAL && c.getX() + shipSize >= size) return false;
        if (ship.getLayout() == Layout.VERTICAL && c.getY() + shipSize >= size) return false;

        Set<Coordinates> tmp = new HashSet<Coordinates>();
        if (ship.getLayout() == Layout.HORIZONTAL) {
            for (int x = ship.getCoordinates().getX(); x < ship.getCoordinates().getX() + shipSize; ++x) {
                Coordinates tmpC = new Coordinates(x, ship.getCoordinates().getY());
                tmp.add(tmpC);
                if (coordinates.contains(tmpC)) return false;
            }
        } else {
            for (int y = ship.getCoordinates().getY(); y < ship.getCoordinates().getY() + shipSize; ++y) {
                Coordinates tmpC = new Coordinates(ship.getCoordinates().getX(), y);
                tmp.add(tmpC);
                if (coordinates.contains(tmpC)) return false;
            }

        }
        coordinates.addAll(tmp);

        return true;
    }

    public boolean destroy(Coordinates c){
            if (!coordinates.contains(c))
                return false;
            System.out.println("Ship destroyed..!!");
            coordinates.remove(c);
            return true;
    }
}
