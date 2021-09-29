package com.codecool.ants;

import com.codecool.ants.geometry.Position;
import com.codecool.ants.hive.*;

import java.util.LinkedList;
import java.util.Random;

public class Colony {

    private final int width;
    private final Position[][] positions;
    private final LinkedList<Ant> ants = new LinkedList<>();
    private Queen queen;

    Random rand = new Random();

    public Colony(int newWidth) {
        width = newWidth;
        positions = new Position[width][width];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < width; y++) {
                positions[x][y] = new Position(x, y);
            }
        }
        this.queen = new Queen(positions[Math.round(width / 2)][Math.round(width / 2)]);
        ants.add(queen);
    }

    public Position[][] getPositions() {
        return positions;
    }

    public Queen getQueen() {
        return queen;
    }

    public int getWidth() {
        return width;
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < width; y++) {
                sb.append(symbolSelector(positions[x][y])).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private String symbolSelector(Position position) {
        try {
            Ant ant = position.getAnt();
            return ant.getSymbol();
        } catch (NullPointerException npe) {
            return ".";
        }
    }

    public void generateAnts(int drones, int workers, int soldiers) {
        if (drones + workers + soldiers > width * width - 1) {
            throw new StackOverflowError();
        }
        for (int i = 0; i < drones; i++) {
            ants.add(new Drone(randomPlacement()));
        }
        for (int i = 0; i < workers; i++) {
            ants.add(new Worker(randomPlacement()));
        }
        for (int i = 0; i < soldiers; i++) {
            ants.add(new Soldier(randomPlacement()));
        }
    }

    private Position randomPlacement() {
        Position selection = positions[rand.nextInt(width)][rand.nextInt(width)];
        if (selection.getAnt() == null) {
            return selection;
        } else {
            return randomPlacement();
        }
    }

    public void update() {
        for (Ant ant : ants) {
            ant.act(this);
        }
    }
}
