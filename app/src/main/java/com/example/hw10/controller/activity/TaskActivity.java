package com.example.hw10.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.hw10.R;
import com.example.hw10.controller.fragment.TaskFragment;

import static com.example.hw10.controller.fragment.MainActivityFragment.EXTRA_NUMBER_TASK;

public class TaskActivity extends AppCompatActivity {


    public static final String EXTRA_COUNT_TASK = "EXTRA_COUNT_TASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);


        sendIntent();

        TaskFragment taskFragment = new TaskFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.task_activity, taskFragment)
                .commit();
    }

    private void sendIntent() {
        int count = Integer.parseInt(getIntent().getExtras().getString(EXTRA_NUMBER_TASK));
        Intent intent = new Intent(TaskActivity.this, TaskFragment.class);
        intent.putExtra(EXTRA_COUNT_TASK, count);
    }
}