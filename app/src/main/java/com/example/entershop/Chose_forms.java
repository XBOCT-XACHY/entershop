package com.example.entershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

public class Chose_forms extends AppCompatActivity {

    ArrayList<AAA> forms;
    ListView listView;
    String selected;
    String[] strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_forms);
        listView = findViewById(R.id.list);

        Intent intent = getIntent();
        selected = intent.getStringExtra("selected");

        if (Objects.equals(selected, "Sonic")) {
            strings = getResources().getStringArray(R.array.sonicforms);
        }
        else if (Objects.equals(selected, "Shadow")){
            strings = getResources().getStringArray(R.array.shadowforms);
        }
        else if (Objects.equals(selected, "Eggman")){
            strings = getResources().getStringArray(R.array.eggmanforms);
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter1);

        forms = new ArrayList<>();
        forms.add(new AAA("Атака титанов", getString(R.string.info_attakontitan), R.drawable.attacktitan));
        forms.add(new AAA("Токийский гуль", getString(R.string.info_tokyo_ghoul), R.drawable.tokyo_ghoul));
        forms.add(new AAA("Мастера меча онлайн", getString(R.string.info_sao), R.drawable.sao));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        selected ="Sonic";
                        nextactiv();
                        break;
                    case 1:
                        selected = "Shadow";
                        nextactiv();
                        break;
                    case 2:
                        selected = "Eggman";
                        nextactiv();
                        break;
                }
            }});
    }
    void nextactiv(){
        Intent intent = new Intent();
        intent.putExtra("selected", selected);
        startActivity(intent);
    }
}