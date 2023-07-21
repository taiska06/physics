package com.example.physics.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physics.Lesson.MexanicFragment;
import com.example.physics.Lesson.TermodinamicFragment;
import com.example.physics.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapterMexanic extends RecyclerView.Adapter<MyAdapterMexanic.MyRow> {

    private ArrayList<MexanicFragment.WeatherItem> itemArrayListMexanic;


    public MyAdapterMexanic(ArrayList<MexanicFragment.WeatherItem> generateData) {
        this. itemArrayListMexanic = generateData;
    }

    @NonNull
    @Override
    public MyRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRow holder, int position) {
        holder.tv.setText( itemArrayListMexanic.get(position).getName());
        Picasso.get().load(  itemArrayListMexanic.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return  itemArrayListMexanic.size();
    }

    class MyRow extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView imageView;

        public MyRow(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
