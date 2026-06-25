package com.pokemon.engine.controller;

import com.pokemon.engine.dto.PokemonApiResponse;
import com.pokemon.engine.dto.PokemonListResponse;
import com.pokemon.engine.service.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/pokemons")
@AllArgsConstructor
public class PokemonController {
	
	private final PokemonService pokemonService ;
	
	@GetMapping("/{name}")
	public ResponseEntity<PokemonApiResponse> getPokemon(@PathVariable String name) {
		return ResponseEntity.ok(pokemonService.getPokemon(name));
	}

	@GetMapping
	public ResponseEntity<PokemonListResponse> listPokemons(
			@RequestParam(required = false) Integer offset,
			@RequestParam(required = false) Integer limit) {
		return ResponseEntity.ok(pokemonService.getPokemons(offset, limit));
	}
}
