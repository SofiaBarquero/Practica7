package com.Sofia.Practica6.service;


import com.Sofia.Practica6.model.Jugador;

public interface JugadorService {
    Jugador updateJugador(String nombre, Jugador jugador);
    void deleteJugador(String nombre);
    Jugador retrieveJugador(String nombre);
}