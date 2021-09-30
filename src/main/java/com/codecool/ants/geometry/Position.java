package com.codecool.ants.geometry;

import com.codecool.ants.hive.Ant;

public class Position {

    public final int x;
    public final int y;
    private Ant ant = null;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getCoordinate(){
        return this;
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }
}