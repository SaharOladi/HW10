package com.example.hw10.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hw10.R;
import com.example.hw10.controller.activity.TaskActivity;

public class MainActivityFragment extends Fragment {

    public static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";
    public static final String EXTRA_NUMBER_TASK = "EXTRA_NUMBER_TASK";
    private Button mCreateButton;
    private EditText userName;
    private EditText numberTask;

    public MainActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_activity, container, false);

        findViews(view);
        setListener();



        return view;
    }

    private void setListener(){
        mCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendIntent();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.main_activity_fragment, new TaskFragment())
//                        .commit();
            }
        });
    }

    private void sendIntent(){
        Intent intent = new Intent(getActivity(), TaskActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName.getText().toString());
        intent.putExtra(EXTRA_NUMBER_TASK, numberTask.getText().toString());
        startActivity(intent);
    }

    private void findViews(View view){
        mCreateButton = view.findViewById(R.id.createButton);
        userName = view.findViewById(R.id.editTextPersonName);
        numberTask = view.findViewById(R.id.editTextNumber);
    }
}