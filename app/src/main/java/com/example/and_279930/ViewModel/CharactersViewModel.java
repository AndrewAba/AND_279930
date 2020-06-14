package com.example.and_279930.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.and_279930.Model.Character;
import com.example.and_279930.Repositories.CharacterRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CharactersViewModel extends AndroidViewModel {

    private CharacterRepository characterRepository;

    public CharactersViewModel(Application application) {
        super(application);
        characterRepository = CharacterRepository.getInstance(application);
    }

    public LiveData<List<Character>> getCharacters() throws ExecutionException, InterruptedException {
        return characterRepository.getCharacters();
    }

    public void removeItem(int pos) throws ExecutionException, InterruptedException {
        characterRepository.removeCharacter(pos);
    }

}
