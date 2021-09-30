package com.codecool.ants;

public enum Settings {
    COLONYWIDTH(15),
    QUEENSMOOD(50),
    DRONES(5),
    SOLDIERS(5),
    WORKERS(5);

    public final int value;

    Settings(int value) {
        this.value = value;
    }
}
