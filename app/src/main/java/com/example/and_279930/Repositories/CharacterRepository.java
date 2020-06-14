package com.example.and_279930.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.and_279930.Model.Character;
import com.example.and_279930.Model.Database.AppDao;
import com.example.and_279930.Model.Database.AppDatabase;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CharacterRepository {
    private AppDao dao;
    private static CharacterRepository instance;

    private MutableLiveData<List<Character>> characters;

    public CharacterRepository(Application app) {
        AppDatabase appDatabase = AppDatabase.getInstance(app);
        dao = appDatabase.appDao();
        characters = new MutableLiveData<>();
    }

    public static synchronized CharacterRepository getInstance(Application app) {
        if (instance == null) {
            instance = new CharacterRepository(app);
        }
        return instance;
    }

    public void insert(Character character) throws ExecutionException, InterruptedException {
        new CharacterRepository.InsertAsyncTask(dao).execute(character);

        List<Character> characters = getCharactersFromDB();
        this.characters.postValue(characters);
    }

    public List<Character> getCharactersFromDB() throws ExecutionException, InterruptedException {
        return new GetCharacters(dao).execute().get();
    }

    public LiveData<List<Character>> getCharacters() {
        return characters;
    }

    public void removeCharacter(int pos) throws ExecutionException, InterruptedException {
        List<Character> list = getCharactersFromDB();
        Character temp = list.get(pos);
        new RemoveItemAsync(dao).execute(temp);
    }

    public static class RemoveItemAsync extends AsyncTask<Character, Void, Void> {
        private AppDao dao;

        private RemoveItemAsync(AppDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Character... characters) {
            dao.removeChar(characters[0]);
            return null;
        }
    }


    public static class GetCharacters extends AsyncTask<Void, Void, List<Character>> {

        private AppDao dao;

        private GetCharacters(AppDao dao) {
            this.dao = dao;
        }

        @Override
        protected List<Character> doInBackground(Void... voids) {
            return dao.getCharacters();
        }
    }

    private static class InsertAsyncTask extends AsyncTask<Character, Void, Void> {

        private AppDao dao;

        private InsertAsyncTask(AppDao appDao) {
            this.dao = appDao;
        }


        @Override
        protected Void doInBackground(Character... characters) {
            dao.insertCharacter(characters[0]);
            return null;
        }
    }
}
