package com.codecool.ants.hive;

import com.codecool.ants.Colony;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;


public class Worker extends Ant {

    public Worker(Position position) {
        super(position,"W");
    }

    public void act(Colony colony) {
        Position[][] positions = colony.getPositions();
        Position currentPosition = this.getPosition();
        int randomIndex = random.nextInt(4);
        Direction randomDirection= Direction.values()[randomIndex];
        try {
            Position nextPosition = getNextPosition(currentPosition, randomDirection, positions);
            this.resetPosition();
            this.setPosition(nextPosition);
        } catch (IndexOutOfBoundsException movedOut) {
            act(colony);
        }
    }

}
