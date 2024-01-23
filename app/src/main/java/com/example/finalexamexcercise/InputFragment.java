package com.example.finalexamexcercise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
    private Button inputButton;
    private EditText nameField, nimField, emailField, phoneField;
    private TextView errorMsg;

    public InputFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
//    public static InputFragment newInstance(String param1, String param2) {
//        InputFragment fragment = new InputFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);


        nameField = view.findViewById(R.id.nameField);
        nimField = view.findViewById(R.id.nimField);
        emailField = view.findViewById(R.id.emailField);
        phoneField = view.findViewById(R.id.phoneField);
        errorMsg = view.findViewById(R.id.errorMsg);
        

        inputButton = view.findViewById(R.id.buttonInput);

        inputButton.setOnClickListener(this);
        
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == inputButton) {
            String name = nameField.getText().toString();
            String nim = nimField.getText().toString();
            String email = emailField.getText().toString();
            String phone = phoneField.getText().toString();
            
            if(name.isEmpty()){
                errorMsg.setText("Please input your Name!");
            }
            
            else if (nim.isEmpty()){
                errorMsg.setText("Please input your NIM!");
            }
            
            else if (nim.length() < 10){
                errorMsg.setText("NIM must be at least 10 characters long!");
            }
            
            else if (email.isEmpty()){
                errorMsg.setText("Please input your Email!");
            }
            
            else if (!email.endsWith("@binus.ac.id")){
                errorMsg.setText("Email must ends with '@binus.ac.id'");
            }
            
            else if (phone.length() < 6){
                errorMsg.setText("Phone number must be at least 6 characters long!");
            } else {
                errorMsg.setText("Data successfully inputed");
            }


            
//            Toast.makeText(this.getContext(), "Data successfully inputed", Toast.LENGTH_SHORT).show();
        }
    }
}