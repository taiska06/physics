package com.example.physics.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physics.Lesson.ElectrodinamicFragment;
import com.example.physics.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapterElectrodinamic extends RecyclerView.Adapter<MyAdapterElectrodinamic.MyRow> {

    private ArrayList<ElectrodinamicFragment.WeatherItem> itemArrayListTElectrodinamic;


    public MyAdapterElectrodinamic(ArrayList<ElectrodinamicFragment.WeatherItem> generateData) {
        this.itemArrayListTElectrodinamic = generateData;
    }

    @NonNull
    @Override
    public MyRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRow holder, int position) {
        holder.tv.setText(itemArrayListTElectrodinamic.get(position).getName());
        Picasso.get().load( itemArrayListTElectrodinamic.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemArrayListTElectrodinamic.size();
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
