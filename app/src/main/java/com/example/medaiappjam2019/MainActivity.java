package com.example.medaiappjam2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] temp = {"C:\\Users\\ShiYu Qiu\\StudioProjects\\MedAIAppJam2019\\app\\src\\main\\assets\\data.json","2"};
        try {
            Log.d("output","starting main");
            RandomForestClassifier.main(temp);
        }catch (Exception ex){
            Log.d("output", "OPS ..."+ex);
        }

    }
}
