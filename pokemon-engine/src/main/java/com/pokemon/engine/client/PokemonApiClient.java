package com.pokemon.engine.client;


import com.pokemon.engine.dto.PokemonApiResponse;
import com.pokemon.engine.dto.PokemonListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PokemonApiClient {
	
	private final WebClient webClient ;
	
	public PokemonApiResponse getPokemon(String name) {
		return webClient.get()
				.uri("/pokemon/{name}", name)
				.retrieve()
				.bodyToMono(PokemonApiResponse.class)
				.block();
	}

	public PokemonListResponse getPokemons(Integer offset, Integer limit) {
		return webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("/pokemon")
						.queryParamIfPresent("offset", Optional.ofNullable(offset))
						.queryParamIfPresent("limit", Optional.ofNullable(limit))
						.build())
				.retrieve()
				.bodyToMono(PokemonListResponse.class)
				.block();
	}
}
