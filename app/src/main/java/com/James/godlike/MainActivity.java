package com.James.godlike;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView main_title_txt = findViewById(R.id.main_title_txt);

        main_title_txt.setText(BuildConfig.BaseUrl);
    }
}