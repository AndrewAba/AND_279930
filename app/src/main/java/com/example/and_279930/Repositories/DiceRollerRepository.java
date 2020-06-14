package com.example.and_279930.Repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.and_279930.API.API;
import com.example.and_279930.API.APIConsumer;
import com.example.and_279930.Model.Dice;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DiceRollerRepository {

    private static final String TAG = "DiceRollerRepository";

    private static DiceRollerRepository instance;
    private MutableLiveData<List<Dice>> dice;
    private API api;

    public DiceRollerRepository(Application app) {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        api = retrofit.create(API.class);
        dice = new MutableLiveData<>();
    }

    public static synchronized DiceRollerRepository getInstance(Application app) {
        if (instance == null) {
            instance = new DiceRollerRepository(app);
        }
        return instance;
    }


    public void rollD4() {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        API api = retrofit.create(API.class);
        final Call<List<Dice>> call = api.getD4();

        call.enqueue(new Callback<List<Dice>>() {
            @Override
            public void onResponse(@NotNull Call<List<Dice>> call, @NotNull Response<List<Dice>> response) {
                List<Dice> dices = response.body();
                for (Dice dice : dices) {
                    int type_content = 0;
                    int value_content = 0;
                    value_content = dice.getValue();
                    type_content = dice.getDice();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Dice>> call, @NotNull Throwable t) {
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void rollD6() {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        API api = retrofit.create(API.class);
        final Call<List<Dice>> call = api.getD6();

        call.enqueue(new Callback<List<Dice>>() {
            @Override
            public void onResponse(@NotNull Call<List<Dice>> call, @NotNull Response<List<Dice>> response) {
                List<Dice> dices = response.body();
                for (Dice dice : dices) {
                    int type_content = 0;
                    int value_content = 0;
                    value_content = dice.getValue();
                    type_content = dice.getDice();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Dice>> call, @NotNull Throwable t) {
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void rollD8() {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        API api = retrofit.create(API.class);
        final Call<List<Dice>> call = api.getD8();

        call.enqueue(new Callback<List<Dice>>() {
            @Override
            public void onResponse(@NotNull Call<List<Dice>> call, @NotNull Response<List<Dice>> response) {
                List<Dice> dices = response.body();
                for (Dice dice : dices) {
                    int type_content = 0;
                    int value_content = 0;
                    value_content = dice.getValue();
                    type_content = dice.getDice();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Dice>> call, @NotNull Throwable t) {
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void rollD10() {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        API api = retrofit.create(API.class);
        final Call<List<Dice>> call = api.getD10();

        call.enqueue(new Callback<List<Dice>>() {
            @Override
            public void onResponse(@NotNull Call<List<Dice>> call, @NotNull Response<List<Dice>> response) {
                List<Dice> dices = response.body();
                for (Dice dice : dices) {
                    int type_content = 0;
                    int value_content = 0;
                    value_content = dice.getValue();
                    type_content = dice.getDice();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Dice>> call, @NotNull Throwable t) {
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void rollD12() {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        API api = retrofit.create(API.class);
        final Call<List<Dice>> call = api.getD12();

        call.enqueue(new Callback<List<Dice>>() {
            @Override
            public void onResponse(@NotNull Call<List<Dice>> call, @NotNull Response<List<Dice>> response) {
                List<Dice> dices = response.body();
                for (Dice dice : dices) {
                    int type_content = 0;
                    int value_content = 0;
                    value_content = dice.getValue();
                    type_content = dice.getDice();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Dice>> call, @NotNull Throwable t) {
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void rollD20() {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        API api = retrofit.create(API.class);
        final Call<List<Dice>> call = api.getD20();

        call.enqueue(new Callback<List<Dice>>() {
            @Override
            public void onResponse(@NotNull Call<List<Dice>> call, @NotNull Response<List<Dice>> response) {
                List<Dice> dices = response.body();
                for (Dice dice : dices) {
                    int type_content = 0;
                    int value_content = 0;
                    value_content = dice.getValue();
                    type_content = dice.getDice();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Dice>> call, @NotNull Throwable t) {
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }

    public void rollD100() {
        Retrofit retrofit = APIConsumer.getInstance().getRetrofitClient();
        API api = retrofit.create(API.class);
        final Call<List<Dice>> call = api.getD100();

        call.enqueue(new Callback<List<Dice>>() {
            @Override
            public void onResponse(@NotNull Call<List<Dice>> call, @NotNull Response<List<Dice>> response) {
                List<Dice> dices = response.body();
                for (Dice dice : dices) {
                    int type_content = 0;
                    int value_content = 0;
                    value_content = dice.getValue();
                    type_content = dice.getDice();
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Dice>> call, @NotNull Throwable t) {
                Log.e(TAG, Objects.requireNonNull(t.getMessage()));
            }
        });
    }
}
