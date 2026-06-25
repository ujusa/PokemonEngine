package com.pokemon.engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PokemonApiResponse {
	private Integer id;
	private String name;
	
	@JsonProperty("base_experience")
	private Integer baseExperience;
	
	private Integer height;
	
	@JsonProperty("is_default")
	private Boolean isDefault;
	
	private Integer order;
	private Integer weight;
	
	private List<PokemonAbility> abilities;
	
	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;
	
	private List<PokemonMove> moves;
	
	private PokemonSprites sprites;
	private PokemonCries cries;
	private List<PokemonStat> stats;
	
}
