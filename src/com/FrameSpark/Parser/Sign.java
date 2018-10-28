package com.FrameSpark.Parser;

public class Sign {
    private char s;
    private int weight;

    Sign (char s,int weight){
        this.s = s;
        this.weight = weight;
    }

    public char getS() {
        return s;
    }

    public void setS(char s) {
        this.s = s;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
