package com.codecool.ants.geometry;

    public enum Direction {
        NORTH(-1,0),
        WEST(0,-1),
        SOUTH(1,0),
        EAST(0,1);

        private final int x;
        private final int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Position getVector(){
            return new Position(x,y);
        }

        public Position getVector(int multiply){
            return new Position(x*multiply,y*multiply);
        }
    }
