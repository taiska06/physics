package com.example.physics.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.physics.Adapter.RecyclerBottomNavigationAdapter;
import com.example.physics.Model.BottomNavigationModel;
import com.example.physics.Fragment.HomeFragment;
import com.example.physics.Fragment.LessonFragment;
import com.example.physics.Fragment.PlanFragment;
import com.example.physics.Listener.OnBottomNavigationItemListener;
import com.example.physics.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public  static  final String BACK_STACK_LESSON = "BACK_STACK_LESSON";
    private  String lastBackStack = BACK_STACK_LESSON;
    private HashMap<String, Stack<Fragment>> backStack;
    private HomeFragment homeFragment;
    private LessonFragment lessonFragment;
    private PlanFragment planFragment;
    private Fragment activeFragment;

    private FragmentManager fragmentManager;

    private RecyclerBottomNavigationAdapter recyclerBottomNavigationAdapter;
    private ArrayList<BottomNavigationModel> bottomNavigationModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialize();
    }

    @Override
    public void onBackPressed() {
        if(!popFragment(lastBackStack)){
            super.onBackPressed();
        }

    }

    private void initialize() {
        fillData();

        initializeUiComponent();

        initializeFragment();
    }

    private void initializeFragment() {
        homeFragment = HomeFragment.newInstance();
        lessonFragment = LessonFragment.newInstance();
        planFragment = PlanFragment.newInstance();
        activeFragment = homeFragment;

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.containerFragment,homeFragment);
        transaction.add(R.id.containerFragment,lessonFragment).hide(lessonFragment);
        transaction.add(R.id.containerFragment,planFragment).hide(planFragment);
        transaction.commit();


    }

    private void fillData() {
        backStack=new HashMap<>();
        backStack.put(BACK_STACK_LESSON,new Stack<>());



        bottomNavigationModels=new ArrayList<>();
        bottomNavigationModels.add(new BottomNavigationModel("Home",R.drawable.ic_sleep_cat2,R.drawable.ic_sleep_cat));
        bottomNavigationModels.add(new BottomNavigationModel("Lesson",R.drawable.ic_catread2,R.drawable.ic_catread));
        bottomNavigationModels.add(new BottomNavigationModel("Plan",R.drawable.ic_catwithpaper2,R.drawable.ic_catwithpaper));
    }

    private void initializeUiComponent() {
        RecyclerView rcyBottomnavigation = findViewById(R.id.rcyBottomNavigation);
        rcyBottomnavigation.setLayoutManager(new GridLayoutManager(this,3));//количество пролетов
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
        fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_HOME);

        activeFragment = homeFragment;
    }
    private void openLessonFragment() {
        fragmentManager.beginTransaction().hide(activeFragment).show(lessonFragment).commit();
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_LESSON);

        if (lastBackStack.equals(BACK_STACK_LESSON)){
            clearBackStack(BACK_STACK_LESSON);
        }
        activeFragment = lessonFragment;
        lastBackStack = BACK_STACK_LESSON;
    }
    private void openPlanFragment() {
        fragmentManager.beginTransaction().hide(activeFragment).show(planFragment).commit();
        recyclerBottomNavigationAdapter.changeItem(RecyclerBottomNavigationAdapter.ITEM_PLAN);


        activeFragment = planFragment;
    }

    public void pushFragmentToStack(String key, Fragment fragment){
        Stack<Fragment> stack = backStack.get(key);
        stack.push(fragment);

    }

    private boolean popFragment(String key){
        Stack<Fragment> stack = backStack.get(key);
        if(stack!= null && !stack.empty()){
            getSupportFragmentManager().beginTransaction().remove(stack.pop()).commit();
            return true;
        }
        return false;
    }

    private void clearBackStack(String key){
        while (true){
            if(!popFragment(key)){
                break;
            }
        }
    }


}