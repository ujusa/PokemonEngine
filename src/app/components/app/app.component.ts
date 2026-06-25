import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { PokemonService } from '../../services/pokemon.service';
import { Pokemon } from '../../models/pokemon.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  searchTerm = '';
  pokemon: Pokemon | null = null;
  loading = false;
  errorMessage = '';
  compareTerm = '';
  comparePokemon: Pokemon | null = null;
  compareError = '';
  mode: 'search' | 'compare' = 'search';
  constructor(private pokemonService: PokemonService) {}

  searchPokemon(): void {

    if (!this.searchTerm.trim()) {
      return;
    }

    this.loading = true;
    this.errorMessage = '';

    this.pokemonService.getPokemon(this.searchTerm)
      .subscribe({
        next: (response) => {
          this.pokemon = response;
          this.loading = false;
        },
        error: () => {
          this.errorMessage = 'Pokemon not found';
          this.loading = false;
        }
      });
  }

  getStats() {
    if (!this.pokemon?.stats) {
      return [];
    }

    return Object.entries(this.pokemon.stats);
  }

searchRandomPokemon(): void {
  const randomId = Math.floor(Math.random() * 1025) + 1;
  this.searchTerm = randomId.toString();
  this.searchPokemon();
}
compareWithPokemon(): void {
  const name = this.compareTerm.trim();

  if (!name) {
    this.compareError = 'Enter a Pokémon to compare.';
    return;
  }

  this.compareError = '';

  this.pokemonService.getPokemon(name).subscribe({
    next: (response) => {
      this.comparePokemon = response;
    },
    error: () => {
      this.compareError = 'Comparison Pokémon not found.';
    }
  });
}

}

