package com.example.and_279930.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.and_279930.Model.Character;
import com.example.and_279930.Repositories.CharacterRepository;

import java.util.concurrent.ExecutionException;

public class CreateCharViewModel extends AndroidViewModel {

    private CharacterRepository characterRepository;

    public CreateCharViewModel(Application application) {
        super(application);
        characterRepository = CharacterRepository.getInstance(application);
    }

    public void insertCharacter(Character character) throws ExecutionException, InterruptedException {
        characterRepository.insert(character);
    }
}
