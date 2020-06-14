package com.example.and_279930.Model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "character_table")
public class Character {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String char_name;
    private String char_class;
    private String race;
    private String char_background;
    private String char_alignment;
    private String char_session;

    public Character(int id, String char_name, String char_class, String race, String char_background, String char_alignment, String char_session) {
        this.id = id;
        this.char_name = char_name;
        this.char_class = char_class;
        this.race = race;
        this.char_background = char_background;
        this.char_alignment = char_alignment;
        this.char_session = char_session;
    }

    @Ignore
    public Character() {
    }

    public Character(String char_name, String char_class, String char_race, String char_background, String char_alignment, String char_session) {
        this.char_name = char_name;
        this.char_class = char_class;
        this.race = char_race;
        this.char_background = char_background;
        this.char_alignment = char_alignment;
        this.char_session = char_session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChar_name() {
        return char_name;
    }

    public void setChar_name(String char_name) {
        this.char_name = char_name;
    }

    public String getChar_class() {
        return char_class;
    }

    public void setChar_class(String char_class) {
        this.char_class = char_class;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getChar_background() {
        return char_background;
    }

    public void setChar_background(String char_background) {
        this.char_background = char_background;
    }

    public String getChar_alignment() {
        return char_alignment;
    }

    public void setChar_alignment(String char_alignment) {
        this.char_alignment = char_alignment;
    }

    public String getChar_session() {
        return char_session;
    }

    public void setChar_session(String char_session) {
        this.char_session = char_session;
    }
}