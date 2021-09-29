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

    public int[] getCoordinate(){
        int[] coordinate = new int[2];
        coordinate[0] = this.x;
        coordinate[1] = this.y;
        return coordinate;
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }
}