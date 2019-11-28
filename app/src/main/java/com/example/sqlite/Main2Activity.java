package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private AdatBazisSegito adatBazisSegito;
    private EditText editTextKeresztnev, editTextVezeteknev, editTextJegy;
    private Button buttonKuldes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        buttonKuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatRogzites();
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void init(){
        adatBazisSegito = new AdatBazisSegito(this);
        editTextKeresztnev = findViewById(R.id.idName);
        editTextVezeteknev = findViewById(R.id.idSurname);
        editTextJegy = findViewById(R.id.idMarks);
        buttonKuldes = findViewById(R.id.idBtn);
    }
    public void adatRogzites(){
        String keresztnev = editTextKeresztnev.getText().toString();
        String vezeteknev = editTextVezeteknev.getText().toString();
        String jegy = editTextJegy.getText().toString();
        boolean eredmeny = adatBazisSegito.adatRogzites(keresztnev, vezeteknev, jegy);
        if (eredmeny)
            Toast.makeText(this, "Adatrögzítés sikeres", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Adatrögzítés sikertelen", Toast.LENGTH_SHORT).show();
    }
}
