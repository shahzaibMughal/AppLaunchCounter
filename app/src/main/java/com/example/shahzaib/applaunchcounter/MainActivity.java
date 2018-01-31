/* This App counts the app launch time */
package com.example.shahzaib.applaunchcounter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countTextView;
    int count;
    final int DEFAULT = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = (TextView) findViewById(R.id.countTextView);

        SharedPreferences sharedPreferences = this.getSharedPreferences("AppLaunchData",MODE_PRIVATE);

        if(sharedPreferences.getInt("count",DEFAULT) == DEFAULT)
        {
            // if app runs first time
            Log.i("1234","App runs first time");
            count = 1;
            sharedPreferences.edit().putInt("count",count).apply();
            countTextView.setText(String.valueOf(sharedPreferences.getInt("count",DEFAULT))); // Yahan pr DEFAULT awain e hy

        }
        else
        {
            Log.i("1234","App runs more then 1 times");
            count = sharedPreferences.getInt("count",DEFAULT);// yahan pr DEFAULT awain he hy
            count++;
            sharedPreferences.edit().putInt("count",count).apply();
            // NOTE: speedUp k liye hum SharedPreference(storage device) sy lyny k bajaey
            //       direct count ko b display krva skty hain. Lekin abi sharedPreference ka use sekh rahy hain
            countTextView.setText(String.valueOf(sharedPreferences.getInt("count",DEFAULT))); // Yahan pr DEFAULT awain e hy
        }


    }
}
