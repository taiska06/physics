package com.example.physics.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.physics.Adapter.NotesListAdapter;
import com.example.physics.Database.RoomDB;
import com.example.physics.Listener.NotesClickListener;
import com.example.physics.Model.Notes;
import com.example.physics.Note.NotesTakerActivity;
import com.example.physics.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class PlanFragment extends Fragment implements  PopupMenu.OnMenuItemClickListener {

    RecyclerView recyclerView;
    NotesListAdapter notesListAdapter;
    List<Notes> notes = new ArrayList<>();
    RoomDB database;
    FloatingActionButton fab_add;

    SearchView searchView_home;
    Notes selectedNote;

    ImageButton back;




    public PlanFragment() {
        // Required empty public constructor
    }


    public static PlanFragment newInstance() {
        return new PlanFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler_home);
        fab_add=view.findViewById(R.id.fab_add);
        searchView_home=view.findViewById(R.id.searchView_home);



        database=RoomDB.getInstance(getContext());

        notes=database.mainDAO().getAll();
        updateRecycler(notes);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), NotesTakerActivity.class);
                startActivityForResult(intent,101);

            }
        });
        searchView_home.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

    }

    private void filter(String newText) {
        List<Notes> filteredList = new ArrayList<>();
        for (Notes singleNote : notes){
            if( singleNote.getTitle().toLowerCase().contains(newText.toLowerCase())
                    || singleNote.getNotes().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(singleNote);
            }

        }
        notesListAdapter.filterList(filteredList);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            if(resultCode== Activity.RESULT_OK){
                Notes new_notes = (Notes) data.getSerializableExtra("note");
                database.mainDAO().insert(new_notes);

                notes.clear();
                notes.addAll(database.mainDAO().getAll());
                notesListAdapter.notifyDataSetChanged();

            }
        }
        else if(requestCode ==102){
            if(resultCode==Activity.RESULT_OK){
                Notes new_notes= (Notes) data.getSerializableExtra("note");
                database.mainDAO().update(new_notes.getID(), new_notes.getTitle(), new_notes.getNotes());
                notes.clear();
                notes.addAll(database.mainDAO().getAll());
                notesListAdapter.notifyDataSetChanged();
            }

        }
    }

    private void updateRecycler(List<Notes> notes) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        notesListAdapter = new NotesListAdapter(getContext(), notes ,notesClickListener);
        recyclerView.setAdapter(notesListAdapter);

    }

    private  final NotesClickListener notesClickListener = new NotesClickListener() {
        @Override
        public void onClick(Notes notes) {
            Intent intent= new Intent(getContext(), NotesTakerActivity.class);
            intent.putExtra("old_note",notes);
            startActivityForResult(intent, 102);

        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {
            selectedNote=new Notes();
            selectedNote=notes;
            showPopup(cardView);

        }
    };

    private void showPopup(CardView cardView) {
        PopupMenu popupMenu= new PopupMenu(getContext(),cardView);
        popupMenu.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pin:
                if(selectedNote.isPinned()){
                    database.mainDAO().pin(selectedNote.getID(),false);
                    Toast.makeText(getContext(), "Unpinned", Toast.LENGTH_SHORT).show();

                }else{
                    database.mainDAO().pin(selectedNote.getID(),true);
                    Toast.makeText(getContext(), "Pinned", Toast.LENGTH_SHORT).show();
                }

                notes.clear();
                notes.addAll(database.mainDAO().getAll());
                notesListAdapter.notifyDataSetChanged();
                return  true;
            case R.id.delete:
                database.mainDAO().delete(selectedNote);
                notes.remove(selectedNote);
                notesListAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                return  true;
        }
        return false;
    }

    }





