package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    AdatBazisSegito adatBazisSegito;
    Button modositasButton;
    EditText editid, editkeresztnev, editvezeteknev, editjegy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        init();
        modositasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           if (Integer.parseInt(editjegy.getText().toString()) <= 5 && Integer.parseInt(editjegy.getText().toString()) >= 1){
               adatModositas();
           }
           else
           {
               Toast.makeText(Main4Activity.this, "Nem jó intervallum", Toast.LENGTH_SHORT).show();
           }
                Intent vissza = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    public void init(){
        adatBazisSegito = new AdatBazisSegito(Main4Activity.this);
        modositasButton = findViewById(R.id.editButton);
        editid = findViewById(R.id.editId);
        editkeresztnev = findViewById(R.id.editKeresztnev);
        editvezeteknev = findViewById(R.id.editVezeteknev);
        editjegy = findViewById(R.id.editJegy);

    }

    public void adatModositas(){
    String id = editid.getText().toString();
    String keresztnev = editkeresztnev.getText().toString();
    String vezeteknev = editvezeteknev.getText().toString();
    String jegy = editjegy.getText().toString();
    long erintettSorok = adatBazisSegito.adatModosit(id, keresztnev, vezeteknev, jegy);
    switch ((int) erintettSorok){
        case -1:
            Toast.makeText(this, "Sikertelen Módosítás", Toast.LENGTH_SHORT).show();
            break;
        case 0:
            Toast.makeText(this, "Az adott id-vel nincs egy rekord se", Toast.LENGTH_SHORT).show();
            break;
        default:
            Toast.makeText(this, "Sikeres Módosítás", Toast.LENGTH_SHORT).show();
            break;
    }
    }
}
