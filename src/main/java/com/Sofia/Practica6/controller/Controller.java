package com.Sofia.Practica6.controller;

import com.Sofia.Practica6.model.Juego;
import com.Sofia.Practica6.model.Jugador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@RestController
public class Controller implements WebMvcConfigurer {

    Jugador jugador;
    Juego juego;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/finJuego").setViewName("finJuego");
    }

    @PostMapping("/EnviarFormularioJugador")
    public ResponseEntity<String> jugador(
            @Valid @RequestBody Jugador jugador,
            BindingResult bindingResult){
        this.jugador=jugador;

        System.out.println(jugador);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @PostMapping("/EnviarFormJuego")
    public ResponseEntity<String> incluirJuego(@Valid @ModelAttribute("juego") Juego j, BindingResult bindingResult, Model model){

        model.addAttribute("juego", j);
        jugador.setNivel(j.getNivel());
        jugador.setAciertos(j.getAciertos());
        this.juego=j;
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @GetMapping("/mostrarInfo")
    public ResponseEntity<Jugador> infoJugador(Model model){

        Jugador jugador =this.jugador;

        return new ResponseEntity<>(jugador, HttpStatus.OK);
    }
}
