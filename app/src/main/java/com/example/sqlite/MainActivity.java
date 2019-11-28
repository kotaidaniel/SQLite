package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AdatBazisSegito adatBazisSegito;
    private TextView textVieweredmeny;
    private Button lekerdezes;
    private Button rogzites;
    private Button torles;
    private Button modositas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        textVieweredmeny.setMovementMethod(new ScrollingMovementMethod());
        lekerdezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adatLekerdezes();
            }
        });
        rogzites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
        torles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
                finish();
            }
        });
        modositas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void init(){
        adatBazisSegito = new AdatBazisSegito(this);
        textVieweredmeny = findViewById(R.id.idResult);
        lekerdezes = findViewById(R.id.idBtn2);
        rogzites = findViewById(R.id.idBtn3);
        torles = findViewById(R.id.idBtn4);
        modositas = findViewById(R.id.idModositas);

    }

    public void adatLekerdezes(){
        Cursor eredmeny = adatBazisSegito.adatLekerdezes();
        StringBuffer stringBuffer = new StringBuffer();
        if (eredmeny != null && eredmeny.getCount() > 0){
            while(eredmeny.moveToNext()){
                stringBuffer.append("ID: " + eredmeny.getString(0) + "\n");
                stringBuffer.append("Keresztnév: " + eredmeny.getString(1) + "\n");
                stringBuffer.append("Vezetéknév: " + eredmeny.getString(2) + "\n");
                stringBuffer.append("Jegy: " + eredmeny.getString(3) + "\n\n");
            }
            textVieweredmeny.setText(stringBuffer.toString());
            Toast.makeText(this, "Adat sikeresen lekérdezve", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Nincs adat az adatbázisban", Toast.LENGTH_SHORT).show();
    }
}
