package com.example.hw10.controller.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hw10.R;
import com.example.hw10.controller.TaskState;


import static com.example.hw10.controller.fragment.MainActivityFragment.EXTRA_NUMBER_TASK;
import static com.example.hw10.controller.fragment.MainActivityFragment.EXTRA_TASK_NAME;


public class TaskFragment extends Fragment {

    private RecyclerView mRecyclerView;


    public TaskFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_task, container, false);

        findViews(view);
        initViews();


        return view;
    }

    private void initViews() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        TaskAdapter taskAdapter = new TaskAdapter();
        mRecyclerView.setAdapter(taskAdapter);
    }

    private void findViews(View view){
        mRecyclerView = view.findViewById(R.id.task_fragment_recyclerview);
    }


    private class TaskHolder extends RecyclerView.ViewHolder{

        private TextView mTaskName;
        private TextView mTaskState;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTaskName = itemView.findViewById(R.id.row_task_name);
            mTaskState = itemView.findViewById(R.id.row_task_state);

        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{

        private int count = Integer.parseInt(getActivity().getIntent().getExtras().getString(EXTRA_NUMBER_TASK));
        private String name = getActivity().getIntent().getExtras().getString(EXTRA_TASK_NAME);

        @Override
        public int getItemCount() {
            return count;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).
                    inflate(R.layout.row_holder, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            return taskHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {

            String state = String.valueOf(selectRandom());

            holder.mTaskName.setText(name);
            holder.mTaskState.setText(state);
            if(position%2==0){
                holder.itemView.setBackgroundColor(Color.rgb(205,220, 57));
            }else
                holder.itemView.setBackgroundColor(Color.rgb(0,188, 212));


        }

        private TaskState selectRandom(){
            return TaskState.values()[(int) (Math.random() * TaskState.values().length)];
        }


    }
}