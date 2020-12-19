package com.example.diplom.Main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplom.Entity.Test;
import com.example.diplom.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainMenuTestsAdapter extends RecyclerView.Adapter<MainMenuTestsAdapter.ViewHolder> {

    Context context;
    ArrayList<Test> tests;

    public MainMenuTestsAdapter(Context context, ArrayList<Test> tests){
        this.context = context;
        this.tests = tests;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.test_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(tests.get(position).isPass())
        {
            holder.checked.setImageResource(R.drawable.ic_pass);
        }

        holder.title.setText(tests.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pic;
        TextView title;
        ImageView checked;

        public ViewHolder(View view) {
            super(view);
            pic = view.findViewById(R.id.testPic);
            title = view.findViewById(R.id.testTitle);
            checked = view.findViewById(R.id.testChecked);

        }
    }

}
