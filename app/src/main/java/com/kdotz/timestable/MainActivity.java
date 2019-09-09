package com.kdotz.timestable;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

import static android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar sk = (SeekBar) findViewById(R.id.seekBar);
        int max = 20;
        int startingPos = 10;
        sk.setMax(max);
        sk.setProgress(startingPos);
        timesTable(startingPos);

        sk.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if(progress < min){
                    timesTableNumber = min;
                } else {
                    timesTableNumber = progress;
                }

                timesTable(timesTableNumber);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.N)
    public void timesTable(int value) {

        ListView myListView = findViewById(R.id.listView);
        List<Integer> values = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            values.add(value * i);
        }

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        myListView.setAdapter(arrayAdapter);

    }
}
