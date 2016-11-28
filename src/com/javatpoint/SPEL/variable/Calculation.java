package com.javatpoint.SPEL.variable;

/**
 * Created by Asus x556 on 28-Nov-16.
 */
public class Calculation {
    private int number;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int cube(){
        return number*number*number;
    }
}
