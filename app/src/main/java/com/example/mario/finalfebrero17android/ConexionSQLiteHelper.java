/*
 * Nombre: Mario Olivera Castañeda
 * Fecha: 25/01/2019
 * Programa: Gestión de laboratorios
 */
package com.example.mario.finalfebrero17android;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    private String CREAR_TABLA_JUGADORES = "CREATE TABLE jugadores(nombre TEXT" +
            ", contrasena TEXT)";
    private String CREAR_TABLA_PARTIDAS = "CREATE TABLE partidas(juego INTEGER" +
            ", usuario TEXT, numpartida INTEGER, ganador TEXT)";
    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
//Evento On Create de SQLite
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_JUGADORES);
        db.execSQL(CREAR_TABLA_PARTIDAS);
    }
//Evento on upgrade de SQLite
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS jugadores");
        db.execSQL("DROP TABLE IF EXISTS partidas");
        onCreate(db);
    }
}
