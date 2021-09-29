package com.codecool.ants;

public enum Settings {
    COLONYWIDTH(15),
    QUEENSMOOD(50),
    DRONES(0),
    SOLDIERS(1),
    WORKERS(0);

    public final int value;

    Settings(int value) {
        this.value = value;
    }
}
