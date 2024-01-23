package com.example.finalexamexcercise.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalexamexcercise.R;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    TextView nameTxt, nimTxt, emailTxt, phoneTxt;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTxt = itemView.findViewById(R.id.viewNameTxt);
        nimTxt = itemView.findViewById(R.id.viewNIMTxt);
        emailTxt = itemView.findViewById(R.id.viewEmailTxt);
        phoneTxt = itemView.findViewById(R.id.viewPhoneTxt);

    }
}
