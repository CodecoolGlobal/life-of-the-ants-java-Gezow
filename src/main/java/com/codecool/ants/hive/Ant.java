package com.codecool.ants.hive;

import com.codecool.ants.Colony;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public abstract class Ant {
    private Position position;
    private String symbol;

    protected Random random = new Random();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        position.setAnt(this);
    }

    public void resetPosition() {
        if (position.getAnt() == this) {
            position.setAnt(null);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public abstract void act(Colony colony);

    public Position getNextPosition(Position currentPosition, Direction direction, Position[][] positions) {
        Position directionalPositionVector = direction.getVector();

        int nextX = currentPosition.x + directionalPositionVector.x;
        int nextY = currentPosition.y + directionalPositionVector.y;
        return positions[nextX][nextY];
    }
}

