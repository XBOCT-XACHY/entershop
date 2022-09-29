package com.example.entershop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] forms;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        String[] characters = getResources().getStringArray(R.array.characters);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, characters);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
            }
        }});

    }
}