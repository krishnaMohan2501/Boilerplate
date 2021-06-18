package com.krishna.ship;

import com.krishna.Coordinates;
import com.krishna.Layout;
import com.krishna.ShipType;

public class Cruiser extends Ship {

    public Cruiser(Coordinates coordinates, Layout layout) {
        super(coordinates, layout, ShipType.CRUISER);
    }
}
