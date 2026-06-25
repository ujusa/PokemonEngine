package com.pokemon.engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonStat {
	
	private NamedApiResource stat;
	
	private Integer effort;
	
	@JsonProperty("base_stat")
	private Integer baseStat;
}