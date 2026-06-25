package com.pokemon.engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonAbility {
	
	@JsonProperty("is_hidden")
	private Boolean isHidden;
	
	private Integer slot;
	
	private NamedApiResource ability;
}