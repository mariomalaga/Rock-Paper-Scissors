package com.example.mario.finalfebrero17android;

public class Partidas {
    private String partida;
    private String jugador;
    private String maquina;
    private String gana;
    public Partidas(String partida, String jugador, String maquina, String gana){
        this.partida = partida;
        this.jugador = jugador;
        this.maquina = maquina;
        this.gana = gana;
    }
    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getGana() {
        return gana;
    }

    public void setGana(String gana) {
        this.gana = gana;
    }

}
