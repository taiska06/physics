package com.example.physics.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physics.Model.BottomNavigationModel;
import com.example.physics.Listener.OnBottomNavigationItemListener;
import com.example.physics.R;

import java.util.ArrayList;

public class RecyclerBottomNavigationAdapter extends RecyclerView.Adapter<RecyclerBottomNavigationAdapter.ViewHolder> {
    public static final int ITEM_HOME=0;
    public static final int ITEM_LESSON=1;
    public static final int ITEM_PLAN=2;

    private int clickedItem=ITEM_HOME;
    private ArrayList<BottomNavigationModel> bottomNavigationModels;
    private Context context;
    private OnBottomNavigationItemListener onBottomNavigationItemListener;



    public RecyclerBottomNavigationAdapter(ArrayList<BottomNavigationModel> bottomNavigationModels,
                                           Context context, OnBottomNavigationItemListener onBottomNavigationItemListener){
        this.bottomNavigationModels=bottomNavigationModels;
        this.context=context;
        this.onBottomNavigationItemListener=onBottomNavigationItemListener;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_bottom_navigation_item,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        BottomNavigationModel bottomNavigationModel=bottomNavigationModels.get(position);

        holder.txtTitle.setText(bottomNavigationModel.getTitle());
        if(clickedItem==position){
            holder.imgIcon.setImageResource(bottomNavigationModel.getClickedIcon());
            holder.txtTitle.setTextColor(context.getResources().getColor(R.color.white));
        }else {
            holder.imgIcon.setImageResource(bottomNavigationModel.getNormalIcon());
            holder.txtTitle.setTextColor(context.getResources().getColor(R.color.palitra_1_5));



        }

        holder.lnrItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( onBottomNavigationItemListener != null){
                    onBottomNavigationItemListener.onItemClicked(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return bottomNavigationModels.size();
    }

    public void changeItem(int item){
        clickedItem=item;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout lnrItem;
        ImageView imgIcon;
        TextView txtTitle;


        @SuppressLint("CutPasteId")
        public ViewHolder(@NonNull View view) {
            super(view);

            lnrItem = view.findViewById(R.id.lnrItem);
            imgIcon=view.findViewById(R.id.imgIcon);
            txtTitle=view.findViewById(R.id.txtTitle);
        }
    }
}
