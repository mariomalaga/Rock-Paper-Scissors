package com.example.mario.finalfebrero17android;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> listaUsuarios;
    private ArrayList<String> listaContrasenas;
    private ConexionSQLiteHelper conn;
    private ListView listadoUsuarios;
    private TextView nombreUsuario;
    private EditText contrasena;
    private Button jugar;
    private int contador;
    private boolean correcto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 0;
        conn = new ConexionSQLiteHelper(this, "jugadores.db", null, 1);
        listadoUsuarios = findViewById(R.id.usuarios);
        nombreUsuario = findViewById(R.id.txtnombreusuario);
        contrasena = findViewById(R.id.cajacontrasena);
        jugar = findViewById(R.id.btnjugar);
        datosBaseDatos();
        consultarListasUsuarios();
        consultarListasContrasenas();
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,  listaUsuarios);
        listadoUsuarios.setAdapter(adaptador);
        listadoUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nombreUsuario.setText(listaUsuarios.get(position));
            }
        });
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < listaContrasenas.size(); i++){
                    if(contrasena.getText().toString().equals(listaContrasenas.get(i))){
                        correcto = true;
                    }
                }
                if(correcto == true){
                    Intent intent = new Intent (v.getContext(), Juego.class);
                    startActivity(intent);
                }
                else{
                    contador++;
                    Toast.makeText(getApplicationContext(), "Lleva " + contador + " intento", Toast.LENGTH_SHORT).show();
                }
                if(contador == 3){
                    System.exit(0);
                }
            }
        });
    }
    public void datosBaseDatos(){
        SQLiteDatabase db = conn.getWritableDatabase();
        String borrar = getResources().getString(R.string.borrar);
        String insert = getResources().getString(R.string.insertar) + "('Ángel', 'Audi')";
        String insert1 = getResources().getString(R.string.insertar) + "('María', 'BMW')";
        String insert2 = getResources().getString(R.string.insertar) + "('Juan', 'Toyota')";
        String insert3 = getResources().getString(R.string.insertar) + "('Guadalupe', 'Honda')";
        db.execSQL(borrar);
        db.execSQL(insert);
        db.execSQL(insert1);
        db.execSQL(insert2);
        db.execSQL(insert3);
        db.close();
    }
    public void consultarListasUsuarios(){
        SQLiteDatabase db = conn.getReadableDatabase();
        listaUsuarios = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT nombre FROM jugadores", null);
        while(cursor.moveToNext()){
            listaUsuarios.add(cursor.getString(0));
        }
        db.close();
    }
    public void consultarListasContrasenas(){
        SQLiteDatabase db = conn.getReadableDatabase();
        listaContrasenas = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT contrasena FROM jugadores", null);
        while(cursor.moveToNext()){
            listaContrasenas.add(cursor.getString(0));
        }
        db.close();
    }
}
