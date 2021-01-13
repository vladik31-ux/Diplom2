package com.example.diplom.Main;

import android.content.Context;
import android.content.Intent;
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
import com.example.diplom.Tests.TestsActivities.ActivityTests1;
import com.example.diplom.Tests.TestsActivities.ActivityTests2;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainMenuTestsAdapter extends RecyclerView.Adapter<MainMenuTestsAdapter.ViewHolder> {

    Context context;
    ArrayList<Test> tests;
    String[] passedTests;

    public MainMenuTestsAdapter(Context context, ArrayList<Test> tests, String[] passedTests){
        this.context = context;
        this.tests = tests;
        this.passedTests = passedTests;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.test_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       // if(tests.get(position).getPicture() != 0)
        //{
        //    holder.pic.setImageResource(tests.get(position).getPicture());
        //}

        if(!(passedTests == null)) {
            for (int i = 0; i < passedTests.length; i++) {
                if (tests.get(position).getId() == Integer.parseInt(passedTests[i])) {
                    holder.checked.setImageResource(R.drawable.ic_pass);
                    break;
                }
            }
        }

        holder.title.setText(tests.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return tests.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView title;
        final ImageView checked;

        ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.testTitle);
            checked = view.findViewById(R.id.testChecked);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ActivityTests1.class);
                    v.getContext().startActivity(intent);
                }
            });

        }
    }

}
