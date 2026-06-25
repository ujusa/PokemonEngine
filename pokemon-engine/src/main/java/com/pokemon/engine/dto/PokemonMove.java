package com.pokemon.engine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PokemonMove {
	
	private NamedApiResource move;
	
	@JsonProperty("version_group_details")
	private List<PokemonMoveVersion> versionGroupDetails;
}