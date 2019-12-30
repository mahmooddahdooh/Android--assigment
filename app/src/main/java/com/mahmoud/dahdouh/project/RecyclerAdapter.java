package com.mahmoud.dahdouh.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Student> students;

    public RecyclerAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(students.get(position).getName());
        holder.school.setText(students.get(position).getSchool());
        holder.gender.setImageResource(students.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView school;
        private ImageView gender;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            gender = itemView.findViewById(R.id.gender);
            school = itemView.findViewById(R.id.school);

        }
    }
}
