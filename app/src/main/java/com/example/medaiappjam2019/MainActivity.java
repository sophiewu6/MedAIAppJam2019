package com.example.medaiappjam2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        double[] temp = {0.5,0.5,0.5,0.5,0.5};
        try {
            Log.d("output","starting main");
            Log.d("output",Integer.toString(DecisionTreeClassifier.predict(temp)));
        }catch (Exception ex){
            Log.d("output", "OPS ..."+ex);
        }

    }
}
