package com.example.and_279930.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.and_279930.Model.Character;
import com.example.and_279930.R;
import com.example.and_279930.ViewModel.CreateCharViewModel;

import java.util.concurrent.ExecutionException;

public class CreateCharFragment extends Fragment {

    private CreateCharViewModel createCharViewModel;
    private Button createBtn;
    private EditText name;
    private EditText char_class;
    private EditText race;
    private EditText background;
    private EditText alignment;
    private EditText session;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createCharViewModel = new ViewModelProvider(this).get(CreateCharViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.char_creator_fragment, container, false);
        name = view.findViewById(R.id.editTextCharName);
        char_class = view.findViewById(R.id.editTextCharClass);
        race = view.findViewById(R.id.editTextCharRace);
        background = view.findViewById(R.id.editTextCharBackground);
        alignment = view.findViewById(R.id.editTextCharAlignment);
        session = view.findViewById(R.id.editTextCharSession);
        createBtn = view.findViewById(R.id.buttonCreateChar);

        createBtn.setOnClickListener(v -> {
            String char_name = " ";
            String char_class = " ";
            String char_race = " ";
            String char_background = " ";
            String char_alignment = " ";
            String char_session = " ";

            char_name = this.name.getText().toString();
            char_class = this.char_class.getText().toString();
            char_race = this.race.getText().toString();
            char_background = this.background.getText().toString();
            char_alignment = this.alignment.getText().toString();
            char_session = this.session.getText().toString();

            try {
                createCharViewModel.insertCharacter(new Character(
                        char_name,
                        char_class,
                        char_race,
                        char_background,
                        char_alignment,
                        char_session
                ));
                Toast.makeText(getContext(), "Character Created", Toast.LENGTH_SHORT).show();
            }
            catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        return view;

    }
}
