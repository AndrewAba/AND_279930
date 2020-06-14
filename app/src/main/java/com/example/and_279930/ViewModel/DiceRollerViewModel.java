package com.example.and_279930.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.and_279930.Model.Dice;
import com.example.and_279930.Repositories.DiceRollerRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class DiceRollerViewModel extends AndroidViewModel {

    private DiceRollerRepository diceRollerRepository;

    public DiceRollerViewModel(Application application) {
        super(application);
        diceRollerRepository = DiceRollerRepository.getInstance(application);
    }

    public void rollD4() throws ExecutionException, InterruptedException {
        diceRollerRepository.rollD4();
    }

    public void rollD6() throws ExecutionException, InterruptedException {
        diceRollerRepository.rollD6();
    }

    public void rollD8() throws ExecutionException, InterruptedException {
        diceRollerRepository.rollD8();
    }

    public void rollD10() throws ExecutionException, InterruptedException {
        diceRollerRepository.rollD10();
    }

    public void rollD12() throws ExecutionException, InterruptedException {
        diceRollerRepository.rollD12();
    }

    public void rollD20() throws ExecutionException, InterruptedException {
        diceRollerRepository.rollD20();
    }

    public void rollD100() throws ExecutionException, InterruptedException {
        diceRollerRepository.rollD100();
    }

}

