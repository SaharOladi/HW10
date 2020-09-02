package com.example.hw10.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hw10.R;
import com.example.hw10.controller.fragment.MainActivityFragment;
import com.example.hw10.controller.fragment.TaskFragment;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        TaskFragment taskFragment = new TaskFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.task_activity, taskFragment)
                .commit();
    }
}