package org.example;

    public class Player {
        final String name;
        private int score;

        public Player(String name){
            this.name = name;
            this.score = 0;
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
    }
