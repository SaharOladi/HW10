package com.example.hw10.controller.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hw10.R;

import static com.example.hw10.controller.activity.TaskActivity.EXTRA_COUNT_TASK;
import static com.example.hw10.controller.fragment.MainActivityFragment.EXTRA_NUMBER_TASK;


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
    }

    private void findViews(View view){
        mRecyclerView = view.findViewById(R.id.task_fragment_recyclerview);
    }


    private class TaskHolder extends RecyclerView.ViewHolder{

        private EditText mTaskName;
        private TextView mTaskState;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTaskName = itemView.findViewById(R.id.row_task_name);
            mTaskState = itemView.findViewById(R.id.row_task_state);

        }
    }

    private class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{

        private int count = Integer.parseInt(getActivity().getIntent().getExtras().getString(EXTRA_COUNT_TASK));

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return count;
        }
    }
}