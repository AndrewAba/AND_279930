package com.example.and_279930.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_279930.Model.Character;
import com.example.and_279930.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<Character> characters;
    private CharacterAdapter.OnItemClickListener listener;

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_char_item, parent, false);
        return new CharacterAdapter.ViewHolder(view, listener);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (characters != null && position <= characters.size()) {
            holder.name.setText(characters.get(position).getChar_name() + " ");
            holder.char_class.setText(characters.get(position).getChar_class() + " ");
            holder.race.setText(characters.get(position).getRace() + " ");
            holder.background.setText(characters.get(position).getChar_background() + " ");
            holder.alignment.setText(characters.get(position).getChar_alignment() + " ");
            holder.session.setText(characters.get(position).getChar_session()+" ");
            switch (characters.get(position).getChar_class()) {
                case "Barbarian":
                    holder.image.setBackgroundResource(R.drawable.class_barbarian);
                    break;
                case "Bard":
                    holder.image.setBackgroundResource(R.drawable.class_bard);
                    break;
                case "Cleric":
                    holder.image.setBackgroundResource(R.drawable.class_cleric);
                    break;
                case "Druid":
                    holder.image.setBackgroundResource(R.drawable.class_druid);
                    break;
                case "Fighter":
                    holder.image.setBackgroundResource(R.drawable.class_fighter);
                    break;
                case "Monk":
                    holder.image.setBackgroundResource(R.drawable.class_monk);
                    break;
                case "Paladin":
                    holder.image.setBackgroundResource(R.drawable.class_paladin);
                    break;
                case "Ranger":
                    holder.image.setBackgroundResource(R.drawable.class_ranger);
                    break;
                case "Rogue":
                    holder.image.setBackgroundResource(R.drawable.class_rogue);
                    break;
                case "Sorcerer":
                    holder.image.setBackgroundResource(R.drawable.class_sorcerer);
                    break;
                case "Warlock":
                    holder.image.setBackgroundResource(R.drawable.class_warlock);
                    break;
                case "Wizard":
                    holder.image.setBackgroundResource(R.drawable.class_wizard);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (characters == null) {
            characters = new ArrayList<>();
            return 0;
        }
        return characters.size();
    }

    public interface OnItemClickListener {
        void onRemoveClickListener(int position) throws ExecutionException, InterruptedException;
    }

    public void setOnClickListener(CharacterAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

    public CharacterAdapter(List<Character> characters) {
        this.characters = new ArrayList<>();
        this.characters = characters;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView char_class;
        private TextView race;
        private TextView background;
        private TextView alignment;
        private TextView session;
        private ImageView image;
        private Button removeButton;

        ViewHolder(@NonNull View itemView, CharacterAdapter.OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.text_char_name);
            char_class = itemView.findViewById(R.id.text_char_class);
            race = itemView.findViewById(R.id.text_char_race);
            background = itemView.findViewById(R.id.text_char_background);
            alignment = itemView.findViewById(R.id.text_char_alignment);
            session = itemView.findViewById(R.id.text_char_sesion);
            image = itemView.findViewById(R.id.imageViewChar);
            removeButton = itemView.findViewById(R.id.buttonDeleteChar);

            removeButton.setOnClickListener(v -> {
                if (listener != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        try {
                            listener.onRemoveClickListener(pos);
                        } catch (ExecutionException | InterruptedException e) {
                            e.printStackTrace();
                        }
                        characters.remove(pos);
                    }
                }
            });
        }
    }

}
