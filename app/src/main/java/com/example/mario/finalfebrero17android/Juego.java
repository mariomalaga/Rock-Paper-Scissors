package com.example.mario.finalfebrero17android;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    private ArrayList<Partidas> partidas;
    private ListView listaPartidas;
    private Spinner opcionesJugador;
    private TextView sacaJugador;
    private Button jugarMaquina;
    private String[] opciones;
    private int contador = 0;
    private Partida partida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);
        //ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "jugadores.db", null, 1);
        //final SQLiteDatabase db = conn.getWritableDatabase();
        opcionesJugador = findViewById(R.id.spnjugador);
        opciones = getResources().getStringArray(R.array.opciones_array);
        partidas = new ArrayList<>();
        sacaJugador = findViewById(R.id.txtsacajugador);
        jugarMaquina = findViewById(R.id.btnmaquina);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones_array, android.R.layout.simple_spinner_item);
        opcionesJugador.setAdapter(adapter);
        opcionesJugador.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sacaJugador.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        partida =  new Partida(this, partidas);
        listaPartidas = findViewById(R.id.listadopartidas);
        listaPartidas.setAdapter(partida);
        jugarMaquina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                String jugada;
                Random r = new Random();
                int numeroRandom = r.nextInt(opciones.length - 0) + 0;
                jugada = opciones[numeroRandom];
                Partidas partidajugada = null;
                if(sacaJugador.getText().toString().equals(jugada)){
                    partidajugada = new Partidas(getResources().getString(R.string.numeropartida) + contador,
                            getResources().getString(R.string.jugadorsaca)+ sacaJugador.getText().toString(),
                            getResources().getString(R.string.maquinasaca) + jugada,
                            getResources().getString(R.string.gana) + "Empate");
                }
                else if(sacaJugador.getText().toString().equals("Piedra") && jugada.equals("Papel")){
                    partidajugada = new Partidas(getResources().getString(R.string.numeropartida) + contador,
                            getResources().getString(R.string.jugadorsaca) + sacaJugador.getText().toString(),
                            getResources().getString(R.string.maquinasaca) + jugada,
                            getResources().getString(R.string.gana) + "Maquina");
                }
                else if(sacaJugador.getText().toString().equals("Papel") && jugada.equals("Piedra")){
                    partidajugada = new Partidas(getResources().getString(R.string.numeropartida) + contador,
                            getResources().getString(R.string.jugadorsaca) + sacaJugador.getText().toString(),
                            getResources().getString(R.string.maquinasaca) + jugada,
                            getResources().getString(R.string.gana) + "Jugador");
                }
                else if(sacaJugador.getText().toString().equals("Tijeras") && jugada.equals("Piedra")){
                    partidajugada = new Partidas(getResources().getString(R.string.numeropartida) + contador,
                            getResources().getString(R.string.jugadorsaca) + sacaJugador.getText().toString(),
                            getResources().getString(R.string.maquinasaca) + jugada,
                            getResources().getString(R.string.gana) + "Maquina");
                }
                else if(sacaJugador.getText().toString().equals("Piedra") && jugada.equals("Tijeras")){
                    partidajugada = new Partidas(getResources().getString(R.string.numeropartida) + contador,
                            getResources().getString(R.string.jugadorsaca) + sacaJugador.getText().toString(),
                            getResources().getString(R.string.maquinasaca) + jugada,
                            getResources().getString(R.string.gana) + "Jugador");
                }
                else if(sacaJugador.getText().toString().equals("Papel") && jugada.equals("Tijeras")){
                    partidajugada = new Partidas(getResources().getString(R.string.numeropartida) + contador,
                            getResources().getString(R.string.jugadorsaca) + sacaJugador.getText().toString(),
                            getResources().getString(R.string.maquinasaca) + jugada,
                            getResources().getString(R.string.gana) + "Maquina");
                }
                else if(sacaJugador.getText().toString().equals("Tijeras") && jugada.equals("Papel")){
                    partidajugada = new Partidas(getResources().getString(R.string.numeropartida) + contador,
                            getResources().getString(R.string.jugadorsaca) + sacaJugador.getText().toString(),
                            getResources().getString(R.string.maquinasaca) + jugada,
                            getResources().getString(R.string.gana) + "Jugador");
                }
                partidas.add(partidajugada);
                partida.notifyDataSetChanged();

                //String insert = "INSERT INTO partidas (juego, usuario, numpartida, ganador) VALUES (1,'Angel', "+ contador +", 'jugador')";
                //db.execSQL(insert);
                //db.close();
            }
        });
    }
}
