package com.krishna;

public enum ShipType {
    DESTROYER("Destroyer"),
    CRUISER("Cruiser");

    private String name;

    private ShipType(String name) {
        // TODO Auto-generated constructor stub
        this.name = name;
    }

    public String getName() {
        return name;
    }
}