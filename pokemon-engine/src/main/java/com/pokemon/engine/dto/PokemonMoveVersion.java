package com.pokemon.engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PokemonMoveVersion {
	
	@JsonProperty("move_learn_method")
	private NamedApiResource moveLearnMethod;
	
	@JsonProperty("version_group")
	private NamedApiResource versionGroup;
	
	@JsonProperty("level_learned_at")
	private Integer levelLearnedAt;
	
	private Integer order;
}