package com.example.and_279930.View;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.and_279930.API.API;
import com.example.and_279930.Model.Dice;
import com.example.and_279930.R;


import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiceRollerFragment extends Fragment {

    private Button D4;
    private Button D6;
    private Button D8;
    private Button D10;
    private Button D12;
    private Button D20;
    private Button D100;
    private ImageView imgRoll;
    private TextView textRoll;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dice_roller_fragment, container, false);
        D4 = view.findViewById(R.id.buttonRollDieD4);
        D6 = view.findViewById(R.id.buttonRollDieD6);
        D8 = view.findViewById(R.id.buttonRollDieD8);
        D10 = view.findViewById(R.id.buttonRollDieD10);
        D12 = view.findViewById(R.id.buttonRollDieD12);
        D20 = view.findViewById(R.id.buttonRollDieD20);
        D100 = view.findViewById(R.id.buttonRollDieD100);
        imgRoll = view.findViewById(R.id.imageViewDiceRoll);
        textRoll = view.findViewById(R.id.textViewRollValueType);

        D4.setOnClickListener(v -> {
            imgRoll.setImageResource(R.drawable.d4);
            int max = 4;
            int min = 1;
            int range = max - min + 1;

            int rand = (int) (Math.random() * range) + min;
            textRoll.setText("Roll:" + rand);
        });

        D8.setOnClickListener(v -> {
            imgRoll.setImageResource(R.drawable.d8);
            int max = 8;
            int min = 1;
            int range = max - min + 1;

            int rand = (int) (Math.random() * range) + min;
            textRoll.setText("Roll:" + rand);
        });

        D6.setOnClickListener(v -> {
            imgRoll.setImageResource(R.drawable.d6);
            int max = 6;
            int min = 1;
            int range = max - min + 1;


            int rand = (int) (Math.random() * range) + min;
            textRoll.setText("Roll:" + rand);
        });

        D10.setOnClickListener(v -> {
            imgRoll.setImageResource(R.drawable.d10);
            int max = 10;
            int min = 1;
            int range = max - min + 1;

            int rand = (int) (Math.random() * range) + min;
            textRoll.setText("Roll:" + rand);
        });

        D12.setOnClickListener(v -> {
            imgRoll.setImageResource(R.drawable.d12);
            int max = 12;
            int min = 1;
            int range = max - min + 1;

            int rand = (int) (Math.random() * range) + min;
            textRoll.setText("Roll:" + rand);
        });

        D20.setOnClickListener(v -> {
            imgRoll.setImageResource(R.drawable.d20);
            int max = 20;
            int min = 1;
            int range = max - min + 1;

            int rand = (int) (Math.random() * range) + min;
            textRoll.setText("Roll:" + rand);
        });

        D100.setOnClickListener(v -> {
            imgRoll.setImageResource(R.drawable.d100);
            int max = 100;
            int min = 1;
            int range = max - min + 1;

            int rand = (int) (Math.random() * range) + min;
            textRoll.setText("Roll:" + rand);
        });

        return view;
    }
}
