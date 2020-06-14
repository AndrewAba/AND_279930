package com.example.and_279930;

import com.example.and_279930.Model.Dice;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    Dice dice = new Dice(1, 2);

    @Test
    public void getValue() {
        assertEquals(1, dice.getValue());
    }

    @Test
    public void setValue() {
        dice.setValue(12);
        assertEquals(12,dice.getValue());
    }

    @Test
    public void getDice() {
        assertEquals(2, dice.getDice());
    }

    @Test
    public void setDice() {
        dice.setDice(1000);
        assertEquals(1000, dice.getDice());
    }
}