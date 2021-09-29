package com.codecool.ants.hive;

import com.codecool.ants.Colony;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Soldier extends Ant {
    private boolean firstMove = true;
    private int currentPatrolNumber = 4;
    private Position patrol4;
    private Position patrol1;
    private Position patrol2;
    private Position patrol3;

    public Soldier(Position position) {
        setSymbol("S");
        setPosition(position);
    }

    public void act(Colony colony) {
        Position[][] positions = colony.getPositions();
        Position currentPosition = this.getPosition();
        if (this.firstMove) {
            try {
                int firstIndex = random.nextInt(4);
                Direction firstDirection = Direction.values()[firstIndex];
                int secondIndex = turnLeftDirectionIndex(firstIndex);
                Direction secondDirection = Direction.values()[secondIndex];
                int thirdIndex = turnLeftDirectionIndex(secondIndex);
                Direction thirdDirection = Direction.values()[thirdIndex];
                patrol4 = getNextPosition(currentPosition, firstDirection, positions);
                patrol1 = getNextPosition(patrol4, secondDirection, positions);
                patrol2 = getNextPosition(patrol1, thirdDirection, positions);
                patrol3 = currentPosition;
                this.resetPosition();
                this.setPosition(patrol4);
            }catch (ArrayIndexOutOfBoundsException outPatrol){
                act(colony);
            }
            firstMove = false;
        }else {
            Position nextPosition;
            switch (currentPatrolNumber){
                case 4:
                    nextPosition = patrol1;
                    currentPatrolNumber = 1;
                    break;
                case 1:
                    nextPosition = patrol2;
                    currentPatrolNumber = 2;
                    break;
                case 2:
                    nextPosition = patrol3;
                    currentPatrolNumber = 3;
                    break;
                case 3:
                    nextPosition = patrol4;
                    currentPatrolNumber = 4;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + currentPatrolNumber);
            }
            this.resetPosition();

            this.setPosition(nextPosition);
        }
    }

    public int turnLeftDirectionIndex(int directionIndex) {
        int nextIndex;
        if (directionIndex == 3) {
            nextIndex = 0;
        } else {
            nextIndex = directionIndex + 1;
        }
        return nextIndex;
    }
}
