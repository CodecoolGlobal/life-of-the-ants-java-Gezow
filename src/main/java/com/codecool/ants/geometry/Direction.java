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
        public int[] getCoordinate(){
            int[] coordinate = new int[2];
            coordinate[0] = this.x;
            coordinate[1] = this.y;
            return coordinate;
        }

        public int[] getCoordinate(int multiply){
            int[] coordinate = new int[2];
            coordinate[0] = this.x*multiply;
            coordinate[1] = this.y*multiply;
            return coordinate;
        }
    }
