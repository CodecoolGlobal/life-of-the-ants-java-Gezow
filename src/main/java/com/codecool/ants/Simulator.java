package com.codecool.ants;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        Colony colony = new Colony(Settings.COLONYWIDTH.value);
        colony.generateAnts(Settings.DRONES.value,Settings.WORKERS.value,Settings.SOLDIERS.value);
        simulation(colony);
    }

    private static void simulation(Colony colony){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            colony.display();
            input(scanner, colony);
        }
    }

    private static void input(Scanner scanner, Colony colony){
        String input = scanner.nextLine();
        if (input.equals("")){
            colony.update();
        }else if (input.equals("q")){
            System.exit(0);
        }else{
            input(scanner, colony);
        }
    }

}
