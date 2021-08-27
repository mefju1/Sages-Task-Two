package com.example.task2.Pokemon;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon/fight")
public class PokemonResource {

    private final RestTemplate restTemplate;

    @GetMapping("/{firstPokemon}/{secondPokemon}")
    public List<Object> getPokemonTypes(@PathVariable("firstPokemon") String firstPokemon,
                                        @PathVariable("secondPokemon") String lastPokemon) {

        Object[] pokemons = restTemplate.getForObject("https://pokeapi.co/api/v2/type/" + firstPokemon, Object[].class);
        Object[]  pokemon2 = restTemplate.getForObject("https://pokeapi.co/api/v2/type/" + lastPokemon, Object[].class);
        
        return Arrays.asList(pokemons);
    }
}
