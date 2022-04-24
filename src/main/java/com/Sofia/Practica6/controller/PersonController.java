package com.Sofia.Practica6.controller;

import com.Sofia.Practica6.model.Jugador;
import com.Sofia.Practica6.service.JugadorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@RestController
public class PersonController {

    @Autowired
    private JugadorService jugadorService;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/verJugadores").setViewName("verJugadores");
    }



    @PutMapping("/stock/{nombre}")
    public ResponseEntity<Jugador> updateJugador(@PathVariable String nombre, @RequestBody Jugador jugador) {

        Jugador newJugador = jugadorService.updateJugador(nombre,jugador);
        if(newJugador == null)
        {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newJugador);
    }



    @DeleteMapping("/stock/{nombre}")
    public ResponseEntity<Jugador> deleteDispositivo(@PathVariable String identificador)
    {
        jugadorService.deleteJugador(identificador);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stock/{nombre}")
    public ResponseEntity<Jugador> retrieveDispositivo(@PathVariable String identificador) {

        Jugador j = jugadorService.retrieveJugador(identificador);
        return ResponseEntity.ok().body(j);

    }


}