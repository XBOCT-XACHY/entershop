package com.example.entershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        forms = new ArrayList<>();
        if (Objects.equals(selected, "Sonic")) {
            forms.add(new AAA("Super Sonic", getString(R.string.supersonic), R.drawable.supersonic));
            forms.add(new AAA("Modern Sonic", getString(R.string.modernsonic), R.drawable.modernsonic));
            forms.add(new AAA("Classic Sonic", getString(R.string.classicsonic) , R.drawable.classicsonic));
        } else if (Objects.equals(selected, "Shadow")) {
            forms.add(new AAA("Common Shadow", getString(R.string.shadow), R.drawable.shadow));
            forms.add(new AAA("Super Shadow", getString(R.string.supersonic), R.drawable.supershadow));
        } else if (Objects.equals(selected, "Eggman")){
            forms.add(new AAA("Dr. Eggman", getString(R.string.eggman), R.drawable.eggman));
            AAA drill = forms.get(0);
            Intent intent1 = new Intent(getApplicationContext(), infoAboutform.class);
            intent1.putExtra("title", drill.getTitle());
            intent1.putExtra("info", drill.getInfo());
            intent1.putExtra("resId", drill.getImageResourceId());
            startActivity(intent1);
        }

        ArrayAdapter<AAA> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, forms);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AAA drill = forms.get(position);
                Intent intent = new Intent(getApplicationContext(), infoAboutform.class);
                intent.putExtra("title", drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId", drill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}