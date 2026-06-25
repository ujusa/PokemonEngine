package com.pokemon.engine.service;

import com.pokemon.engine.client.PokemonApiClient;
import com.pokemon.engine.dto.PokemonApiResponse;
import com.pokemon.engine.dto.PokemonListResponse;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PokemonService {
	
	private final PokemonApiClient pokemonApiClient ;
	
	@Cacheable(value = "pokemon", key = "#name.toLowerCase()")
	public PokemonApiResponse getPokemon(String name) {
		return pokemonApiClient.getPokemon(name);
	}
	
	@Cacheable(value = "pokemon", key = "#offset + ':' + #limit")
	public PokemonListResponse getPokemons(Integer offset, Integer limit) {
		return pokemonApiClient.getPokemons(offset, limit);
	}
	
	
}
