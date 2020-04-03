package com.example.mario.finalfebrero17android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Consultar extends AppCompatActivity {
    private ListView listadoConsultar;
    private ArrayList<String> listaConsultar;
    private ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        SQLiteDatabase db = conn.getReadableDatabase();
        listaConsultar = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM partidas", null);
        while(cursor.moveToNext()){
        }
        db.close();
    }
}
