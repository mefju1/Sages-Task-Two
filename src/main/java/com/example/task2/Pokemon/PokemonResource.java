package com.example.task2.Pokemon;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/pokemon/fight")
public class PokemonResource {

    @GetMapping("/{firstPokemon}/{secondPokemon}")
    public ResponseEntity<Pokemon> getPokemonTypes(@PathVariable("firstPokemon") String firstPokemon,
                                                   @PathVariable("secondPokemon") String lastPokemon) {

        return new ResponseEntity<>(new Pokemon(), OK);
    }
}
