package com.example.physics.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physics.Lesson.OpticFragment;
import com.example.physics.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapterOptic extends RecyclerView.Adapter<MyAdapterOptic.MyRow> {

    private ArrayList<OpticFragment.WeatherItem> itemArrayListOptic;


    public MyAdapterOptic(ArrayList<OpticFragment.WeatherItem> generateData) {
        this.itemArrayListOptic = generateData;
    }

    @NonNull
    @Override
    public MyRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRow holder, int position) {
        holder.tv.setText( itemArrayListOptic.get(position).getName());
        Picasso.get().load( itemArrayListOptic.get(position).getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemArrayListOptic.size();
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
