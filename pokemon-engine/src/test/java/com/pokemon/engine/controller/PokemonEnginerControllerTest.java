package com.pokemon.engine.controller;

import com.pokemon.engine.dto.PokemonApiResponse;
import com.pokemon.engine.dto.PokemonListResponse;
import com.pokemon.engine.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PokemonControllerTest {
	
	@Mock
	private PokemonService pokemonService;
	
	@InjectMocks
	private PokemonController pokemonController;
	
	@Test
	void getPokemon_shouldReturnOkResponse() {
		PokemonApiResponse response = new PokemonApiResponse();
		
		when(pokemonService.getPokemon("pikachu")).thenReturn(response);
		
		ResponseEntity<PokemonApiResponse> result =
				pokemonController.getPokemon("pikachu");
		
		assertEquals(200, result.getStatusCode().value());
		assertSame(response, result.getBody());
		verify(pokemonService).getPokemon("pikachu");
	}
	
	@Test
	void listPokemons_shouldReturnOkResponse() {
		PokemonListResponse response = new PokemonListResponse();
		
		when(pokemonService.getPokemons(0, 20)).thenReturn(response);
		ResponseEntity<PokemonListResponse> result =
				pokemonController.listPokemons(0, 20);
		
		assertEquals(200, result.getStatusCode().value());
		assertSame(response, result.getBody());
		verify(pokemonService).getPokemons(0, 20);
	}
}
