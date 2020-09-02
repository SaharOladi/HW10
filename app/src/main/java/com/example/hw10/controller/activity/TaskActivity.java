package com.example.hw10.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hw10.R;
import com.example.hw10.controller.fragment.TaskFragment;


public class TaskActivity extends AppCompatActivity {


//    public static final String EXTRA_COUNT_TASK = "EXTRA_COUNT_TASK";
//    public static final String EXTRA_NAME_TASK = "EXTRA_NAME_TASK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);


//        sendIntent();

        TaskFragment taskFragment = new TaskFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.task_activity, taskFragment)
                .commit();
    }

//    private void sendIntent() {
//        int count = Integer.parseInt(getIntent().getExtras().getString(EXTRA_NUMBER_TASK));
//        String taskName = getIntent().getExtras().getString(EXTRA_TASK_NAME);
//        Intent intent = new Intent(this, TaskFragment.class);
//        intent.putExtra(EXTRA_COUNT_TASK, count);
//        intent.putExtra(EXTRA_NAME_TASK,taskName);
//        startActivity(intent);
//    }
}