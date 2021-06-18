package com.krishna.ship;

import com.krishna.Coordinates;
import com.krishna.Layout;
import com.krishna.ShipType;

public class Destroyer extends Ship {
    public Destroyer(Coordinates coordinates, Layout layout) {
        super(coordinates, layout, ShipType.DESTROYER);
    }
}
