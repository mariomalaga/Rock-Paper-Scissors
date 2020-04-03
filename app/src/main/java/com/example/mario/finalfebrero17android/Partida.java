package com.example.mario.finalfebrero17android;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Partida extends ArrayAdapter {
    Activity actividad;
    ArrayList<Partidas> partidas;
    public Partida(Activity actividad, ArrayList<Partidas>partidas) {
        super(actividad, R.layout.partidas, partidas);
        this.actividad = actividad;
        this.partidas = partidas;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = actividad.getLayoutInflater();
        View item = inflater.inflate(R.layout.partidas, null);
        TextView partida = item.findViewById(R.id.txtnumeropartida);
        partida.setText(partidas.get(position).getPartida());
        partida = item.findViewById(R.id.txtsacojugador);
        partida.setText(partidas.get(position).getJugador());
        partida = item.findViewById(R.id.txtsacomaquina);
        partida.setText(partidas.get(position).getMaquina());
        partida = item.findViewById(R.id.txtgana);
        partida.setText(partidas.get(position).getGana());
        return(item);
    }
}
