package com.example.and_279930.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_279930.Adapters.CharacterAdapter;
import com.example.and_279930.R;
import com.example.and_279930.ViewModel.CharactersViewModel;

import java.util.concurrent.ExecutionException;


public class CharactersFragment extends Fragment {

    private CharactersViewModel charactersViewModel;

    private RecyclerView recyclerView;
    private CharacterAdapter characterAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        charactersViewModel = new ViewModelProvider(this).get(CharactersViewModel.class);
        try {
            charactersViewModel.getCharacters().observe(this, characters -> {

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                characterAdapter = new CharacterAdapter(characters);
                recyclerView.setAdapter(characterAdapter);

                characterAdapter.setOnClickListener(position ->
                {
                    charactersViewModel.removeItem(position);
                    Toast.makeText(getContext(), "Item removed", Toast.LENGTH_SHORT).show();
                    characterAdapter.notifyDataSetChanged();
                });

            });
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.char_fragment, container, false);

        recyclerView = view.findViewById(R.id.rvChars);

        return view;
    }

}
