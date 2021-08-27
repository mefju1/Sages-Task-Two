package com.example.task2.Pokemon;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon/fight")
public class PokemonResource {

    private final RestTemplate restTemplate;

    @GetMapping("/{firstPokemon}/{secondPokemon}")
    public ResponseEntity<Pokemon> getPokemonTypes(@PathVariable("firstPokemon") String firstPokemon,
                                                   @PathVariable("secondPokemon") String lastPokemon) {

        Pokemon pokemon = restTemplate.getForObject("https://pokeapi.co/api/v2/" + firstPokemon, Pokemon.class);

        return new ResponseEntity<>(pokemon, OK);
    }
}
