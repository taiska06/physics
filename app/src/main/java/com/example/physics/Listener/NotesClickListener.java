package com.example.physics.Listener;

import androidx.cardview.widget.CardView;


import com.example.physics.Model.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
