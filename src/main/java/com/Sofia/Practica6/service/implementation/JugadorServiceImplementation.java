package com.Sofia.Practica6.service.implementation;


import com.Sofia.Practica6.model.Jugador;
import com.Sofia.Practica6.repository.RepositorioJugadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JugadorServiceImplementation implements JugadoresService {

    @Autowired
    private RepositorioJugadores repositorioJugadores;


    public Jugador updateJugador(String nombre, Jugador jugador)
    {
        if(repositorioJugadores.existsById(nombre))
        {
            return repositorioJugadores.save(jugador); //para no actualizar un dispositivo que no exista
        }else{
            return null;
        }

    }


    public void deleteJugador(String nombre)
    {
        repositorioJugadores.deleteById(nombre);
    }

    public Jugador retrieveJugador(String nombre)
    {
        Jugador jugador = null;
        if(repositorioJugadores.existsById(nombre)) {
            Iterable<Jugador> jugadores =  repositorioJugadores.retrieveJugador(nombre);

            for (Jugador j: jugadores)
            {
                jugador=j;
            }
        }
        return jugador;
    }

}
