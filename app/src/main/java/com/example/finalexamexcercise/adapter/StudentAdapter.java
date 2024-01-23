package com.example.finalexamexcercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexamexcercise.R;
import com.example.finalexamexcercise.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {

    Context context;
    List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflate = inflater.inflate(R.layout.student_adapter, parent, false);

        return new StudentViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.nameTxt.setText(student.getName());
        holder.nimTxt.setText(student.getName());
        holder.emailTxt.setText(student.getEmail());
        holder.phoneTxt.setText(student.getPhone());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
