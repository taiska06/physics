package com.example.physics.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.physics.Adapter.RecyclerBottomNavigationAdapter;
import com.example.physics.BottomNavigationModel;
import com.example.physics.Listener.OnBottomNavigationItemListener;
import com.example.physics.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerBottomNavigationAdapter recyclerBottomNavigationAdapter;
    private ArrayList<BottomNavigationModel> bottomNavigationModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        fillData();
        initializeUiComponent();
    }

    private void fillData() {
        bottomNavigationModels=new ArrayList<>();
        bottomNavigationModels.add(new BottomNavigationModel("Home",R.drawable.ic_catsleep,R.drawable.ic_catsleep));
        bottomNavigationModels.add(new BottomNavigationModel("Lesson",R.drawable.ic_catlessons,R.drawable.ic_catlessons));
        bottomNavigationModels.add(new BottomNavigationModel("Plan",R.drawable.ic_catwithplan,R.drawable.ic_catwithplan));
    }

    private void initializeUiComponent() {
        RecyclerView rcyBottomnavigation = findViewById(R.id.rcyBottomNavigation);
        rcyBottomnavigation.setLayoutManager(new GridLayoutManager(this,3));
        recyclerBottomNavigationAdapter=new RecyclerBottomNavigationAdapter(bottomNavigationModels, this, new OnBottomNavigationItemListener() {
            @Override
            public void onItemClicked(int position) {
                switch (position){
                    case 0:
                        openHomeFragment();
                        break;
                    case 1:
                        openLessonFragment();
                        break;
                    case 2:
                        openPlanFragment();
                        break;
                }
            }
        });
        rcyBottomnavigation.setAdapter(recyclerBottomNavigationAdapter);
    }

    private void openHomeFragment() {
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_HOME);
    }
    private void openLessonFragment() {
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_LESSON);
    }
    private void openPlanFragment() {
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_PLAN);
    }
}