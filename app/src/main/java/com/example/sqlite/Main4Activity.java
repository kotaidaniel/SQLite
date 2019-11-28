package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    AdatBazisSegito adatBazisSegito;
    Button modositasButton;
    EditText keresztnev, vezeteknev, jegy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        init();
        modositasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatModositas();
                Intent vissza = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    public void init(){
        adatBazisSegito = new AdatBazisSegito(Main4Activity.this);
        modositasButton = findViewById(R.id.editButton);
        keresztnev = findViewById(R.id.editKeresztnev);
        vezeteknev = findViewById(R.id.editVezeteknev);
        jegy = findViewById(R.id.editJegy);

    }

    public void adatModositas(){

    }
}
