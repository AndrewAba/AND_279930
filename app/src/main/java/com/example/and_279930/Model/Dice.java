package com.example.and_279930.Model;

import com.google.gson.annotations.SerializedName;

public class Dice {
    @SerializedName("success")
    private int value;
    @SerializedName("dice")
    private int dice;


    public Dice(int value, int dice) {
        this.value = value;
        this.dice = dice;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }
}



