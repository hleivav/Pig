package org.example;

    public class Player {
        final String name;
        private int score;
        private boolean playStatus;

        public Player(String name, boolean playStatus){
            this.name = name;
            this.score = 0;
            this.playStatus = playStatus;
        }

        public String getName(){
            return name;
        }

        public int playerScore(){
            return this.score;
        }
        public void increaseScore(int updateWith){
            score+= updateWith;
        }
        public void emptyScore(){
            score = 0;
        }
        public boolean playerStatus() {
            return this.playStatus;
        }
        public void changeStatusToFalse(){
            this.playStatus = false;
        }
        public void changeStatusToTrue(){
            this.playStatus = true;
        }
    }
