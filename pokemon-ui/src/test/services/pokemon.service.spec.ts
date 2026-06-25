import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { PokemonService } from '../../app/services/pokemon.service';
import { environment } from '../../environments/environment';
import { Pokemon } from '../../app/models/pokemon.model';

describe('PokemonService', () => {
  let service: PokemonService;
  let httpMock: HttpTestingController;

  const mockPokemon: Pokemon = {
    id: 25,
    name: 'pikachu',
    height: 4,
    weight: 60,
    base_experience: 112,
    abilities: [],
    types: [],
    stats: [],
    sprites: {}
  };

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PokemonService]
    });
    service = TestBed.inject(PokemonService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should GET pokemon using trimmed lowercase name and baseUrl from environment', (done) => {
    service.getPokemon(' PiKaChu ').subscribe({
      next: (res) => {
        expect(res).toEqual(mockPokemon);
        done();
      },
      error: () => {
        fail('should not error');
      }
    });

    const req = httpMock.expectOne(`${environment.apiBaseUrl}/pikachu`);
    expect(req.request.method).toBe('GET');
    req.flush(mockPokemon);
  });

  it('should propagate HTTP errors to subscribers', (done) => {
    service.getPokemon('missing').subscribe({
      next: () => {
        fail('expected an error');
      },
      error: (err) => {
        expect(err.status).toBe(404);
        expect(err.statusText).toBe('Not Found');
        done();
      }
    });

    const req = httpMock.expectOne(`${environment.apiBaseUrl}/missing`);
    req.flush('Not Found', { status: 404, statusText: 'Not Found' });
  });

});
