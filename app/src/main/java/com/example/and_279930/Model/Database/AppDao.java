package com.example.and_279930.Model.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.and_279930.Model.Character;

import java.util.List;

@Dao
public interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setCharacters(Character character);

    @Insert
    void insertCharacter(Character character);


    @Query("SELECT * FROM character_table")
    List<Character> getCharacters();

    @Delete
    void removeChar(Character character);

}

