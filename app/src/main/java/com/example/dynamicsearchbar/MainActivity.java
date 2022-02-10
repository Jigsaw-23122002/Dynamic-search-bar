package com.example.dynamicsearchbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText SearchBar;

    ListView Suggestions;

    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> arrayList = new ArrayList<String>();
    String[] users={"Ava","Amelia","Abigail", "Alexander","Aiden", "Anthony","Emma","Evelyn", "Emily","Elijah",
            "Ethan","Ezra","Luna","Layla", "Lily", "Lucas","Logan","Olivia","Oliver","Owen","Sophia",
            "Scarlett","Stella", "Sebastian","Samuel","Santiago","Ava", "Alexander",
            "Brooklyn","Benjamin", "Charlotte", "Carter","Delilah", "Daniel","Emma", "Elijah","Freya (179)","Finn (178)",
            "Gianna", "Grayson", "Harper", "Henry", "Isabella", "Isaac", "Josephine","James","Kinsley","Kai",
            "Luna","Liam", "Mia", "Mason", "Nora","Noah","Olivia","Oliver", "Penelope","Parker",
            "Quinn","Quinn", "Riley", "Ryan", "Sophia", "Sebastian","Taylor", "Theodore", "Unique", "Uriel",
            "Victoria", "Vincent","Willow", "William","Ximena", "Xavier", "Yaretzi", "Yusuf",
            "Zoey","Zachary"};

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d("Text",""+SearchBar.getText());
            arrayList.clear();
            String search = SearchBar.getText().toString().toLowerCase(Locale.ROOT);
            for (String user : users) {
                Log.d("Text", "" + SearchBar.getText());
                if (user.toLowerCase(Locale.ROOT).startsWith(String.valueOf(search))) {
                    arrayList.add(user);
                }
            }
            arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.custom_layout,arrayList);
            Suggestions.setAdapter(arrayAdapter);
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SearchBar = (EditText) findViewById(R.id.SearchBar);
        Suggestions = (ListView) findViewById(R.id.Suggestions);
        SearchBar.addTextChangedListener(textWatcher);

    }
}