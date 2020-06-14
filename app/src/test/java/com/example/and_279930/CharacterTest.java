package com.example.and_279930;

import com.example.and_279930.Model.Character;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    Character character = new Character("A", "B", "C", "D", "E","F");

    @Test
    public void getChar_name() {
        assertEquals("A", character.getChar_name());
    }

    @Test
    public void setChar_name() {
        character.setChar_name("test");
        assertEquals("test", character.getChar_name());
    }

    @Test
    public void getChar_class() {
        assertEquals("B", character.getChar_class());
    }

    @Test
    public void setChar_class() {
        character.setChar_class("test");
        assertEquals("test", character.getChar_class());
    }

    @Test
    public void getRace() {
        assertEquals("C", character.getRace());
    }

    @Test
    public void setRace() {
        character.setRace("test");
        assertEquals("test", character.getRace());
    }

    @Test
    public void getChar_background() {
        assertEquals("D", character.getChar_background());
    }

    @Test
    public void setChar_background() {
        character.setChar_background("test");
        assertEquals("test", character.getChar_background());
    }

    @Test
    public void getChar_alignment() {
        assertEquals("E", character.getChar_alignment());
    }

    @Test
    public void setChar_alignment() {
        character.setChar_alignment("test");
        assertEquals("test", character.getChar_alignment());
    }

    @Test
    public void getChar_session() {
        assertEquals("F", character.getChar_session());
    }

    @Test
    public void setChar_session() {
        character.setChar_session("test");
        assertEquals("test", character.getChar_session());
    }
}