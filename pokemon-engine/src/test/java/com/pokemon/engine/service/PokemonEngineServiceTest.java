package com.pokemon.engine.service;

import com.pokemon.engine.dto.PokemonApiResponse;
import com.pokemon.engine.dto.PokemonListResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {
	
	@Mock
	private PokemonApiClient pokemonApiClient;
	
	@InjectMocks
	private PokemonService pokemonService;
	
	@Test
	void getPokemon_shouldReturnPokemonFromClient() {
		PokemonApiResponse response = new PokemonApiResponse();
		
		when(pokemonApiClient.getPokemon("pikachu")).thenReturn(response);
		
		PokemonApiResponse result = pokemonService.getPokemon("pikachu");
		
		assertSame(response, result);
		verify(pokemonApiClient).getPokemon("pikachu");
	}
	
	@Test
	void getPokemons_shouldReturnPokemonListFromClient() {
		PokemonListResponse response = new PokemonListResponse();
		
		when(pokemonApiClient.getPokemons(0, 20)).thenReturn(response);
		
		PokemonListResponse result = pokemonService.getPokemons(0, 20);
		
		assertSame(response, result);
		verify(pokemonApiClient).getPokemons(0, 20);
	}
}