package com.example.hw10.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hw10.R;
import com.example.hw10.controller.fragment.MainActivityFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityFragment mainActivityFragment = new MainActivityFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, mainActivityFragment)
                .commit();


    }
}