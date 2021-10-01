package com.codecool.ants.hive;

import com.codecool.ants.Colony;
import com.codecool.ants.Settings;
import com.codecool.ants.geometry.Position;

public class Queen extends Ant {

    private int mood;
    private boolean readyToMate;

    public Queen(Position position) {
        setSymbol("Q");
        setPosition(position);
        mood = Settings.QUEENSMOOD.value + random.nextInt(50);
        readyToMate = false;
    }

    public void act(Colony colony) {
        Position position = this.getPosition();
        this.setPosition(position);
        if (mood > 0){
            mood --;
            System.out.println(mood);
        }else{
            readyToMate = true;
        }
    }

    public boolean isReadyToMate() {
        return readyToMate;
    }

    public void mating(){
        mood = Settings.QUEENSMOOD.value + random.nextInt(50);
        readyToMate = false;
    }
}
