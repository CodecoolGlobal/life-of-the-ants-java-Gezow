package com.codecool.ants.hive;

import com.codecool.ants.Colony;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Drone extends Ant {

    private int pause = 0;

    public Drone(Position position) {
        setSymbol("D");
        setPosition(position);
    }

    public void act(Colony colony) {
        Position[][] positions = colony.getPositions();
        Position currentPosition = this.getPosition();
        Queen queen = colony.getQueen();
        Position queensPosition = queen.getPosition();
        boolean notFound = true;
        while (notFound) {
            int randomIndex = random.nextInt(4);
            Direction randomDirection = Direction.values()[randomIndex];

            try {
                Position nextPosition = getNextPosition(currentPosition, randomDirection, positions);

                if (Math.abs(queensPosition.x - nextPosition.x) < Math.abs(queensPosition.x - currentPosition.x) ||
                        (Math.abs(queensPosition.y - nextPosition.y) < Math.abs(queensPosition.y - currentPosition.y))) {
                    this.resetPosition();
                    if (nextPosition == queensPosition) {
                        if (queen.isReadyToMate()){
                            System.out.println(":D");
                            queen.mating();
                            this.pause = 10;
                            nextPosition = currentPosition;
                        }else {
                            if (pause > 0){
                                pause--;
                                nextPosition = currentPosition;
                            }else {
                                System.out.println(":(");
                                nextPosition = randomEdgePosition(colony, positions, currentPosition);
                            }
                        }
                    }
                    this.setPosition(nextPosition);
                    notFound = false;
                }
            }catch (ArrayIndexOutOfBoundsException movedOut){
                act(colony);
            }
        }
    }

    private Position randomEdgePosition(Colony colony, Position[][] positions, Position currentPosition) {
        int randomIndex;
        Position nextPosition;
        randomIndex = random.nextInt(4);
        Position directionalVector = Direction.values()[randomIndex].getVector(colony.getWidth()/2);
        Position currentPositionCoordinates = currentPosition.getCoordinate();

        nextPosition = positions[currentPositionCoordinates.x+directionalVector.x][currentPositionCoordinates.y+directionalVector.y];
        return nextPosition;
    }


}
