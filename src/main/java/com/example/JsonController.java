package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping("/pokemon")
    public Pokemon getPokemon() {
        Types[] types = new Types[] {
                new Types(2, new Type("http://pokeapi.co/api/v2/type/3/", "flying")),
                new Types(1, new Type("http://pokeapi.co/api/v2/type/10/", "fire"))
        };

        Pokemon pokemon = new Pokemon("charizard", 6, 905, types);

        return pokemon;
    }
}
