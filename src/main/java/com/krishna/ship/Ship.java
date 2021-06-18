package com.krishna.ship;

import com.krishna.Coordinates;
import com.krishna.Layout;
import com.krishna.ShipType;
import lombok.Getter;

@Getter
public abstract class Ship {
    private Layout layout;
    private ShipType shipType;
    private Coordinates coordinates;

    public Ship(Coordinates coordinates, Layout layout, ShipType shipType) {
        // TODO Auto-generated constructor stub
        this.coordinates = coordinates;
        this.layout = layout;
        this.shipType = shipType;
    }

}
