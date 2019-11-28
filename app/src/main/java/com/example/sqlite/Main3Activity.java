package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    AdatBazisSegito adatbazissegito;
    Button torlesButton;
    EditText editTorlendo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();
        torlesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatTotles();
                Intent vissza = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    public void adatTotles(){
        int id = Integer.parseInt(editTorlendo.getText().toString());
        long erintettSorok = adatbazissegito.adatTorles(id);
        switch((int)erintettSorok){
            case -1:
                Toast.makeText(this, "Sikertelen Törlés", Toast.LENGTH_SHORT).show();
                break;
            case 0:
                Toast.makeText(this, "Az adott id-vel nincs egy rekord se", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Sikeres Törlés", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void init(){
        adatbazissegito = new AdatBazisSegito(Main3Activity.this);
        torlesButton = findViewById(R.id.idBtn5);
        editTorlendo = findViewById(R.id.idID);
    }
}
