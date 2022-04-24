package com.Sofia.Practica6.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.Sofia.Practica6.model.Jugador;

public interface RepositorioJugadores extends CrudRepository<Jugador, String> {
    @Query("SELECT * FROM JUGADOR WHERE JUGADOR.NOMBRE= :nombre")
    public Iterable<Jugador> retrieveDispositivoByExistencias(String nombre);

}