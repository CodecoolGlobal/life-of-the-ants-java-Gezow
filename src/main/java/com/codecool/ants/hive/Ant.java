package com.codecool.ants.hive;

import com.codecool.ants.Colony;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Ant {
    private Position position;
    private String symbol;

    Random random = new Random();

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

    public void act(Colony colony) {
    }

    Position getNextPosition(Position currentPosition, Direction direction, Position[][] positions) {
        int[] directionalCoordinates = direction.getCoordinate();
        int[] currentPositionCoordinates = currentPosition.getCoordinate();
        int[] nextPositionCoordinates = new int[2];
        nextPositionCoordinates[0] = currentPositionCoordinates[0] + directionalCoordinates[0];
        nextPositionCoordinates[1] = currentPositionCoordinates[1] + directionalCoordinates[1];
        return positions[nextPositionCoordinates[0]][nextPositionCoordinates[1]];
    }
}

