## Tech Stack

* Java: 17
* Framework: Spring Boot 4.1.0
* Build Tool: Gradle
* IDE Used: IntelliJ IDEA
* Package Manager: Gradle Wrapper
* Cache: Caffeine Cache
* HTTP Client: Spring WebClient
* Framework Modules:

  * Spring Web MVC
  * Spring WebFlux
  * Spring Cache

## Project Setup

### Clone the repository

```bash
git clone < https://github.com/ujusa/PokemonEngine.git>
cd engine
```

### Build the project

```bash
./gradlew build
```

The backend will start on:

```text
http://localhost:8080
```

## Caffeine Cache

The application uses Caffeine Cache to improve performance and reduce repeated external API calls.

When Pokémon data is requested, the response can be cached so that repeated searches for the same Pokémon are served faster without calling the external API again.

Dependency used:

```gradle
implementation 'com.github.ben-manes.caffeine:caffeine:3.1.6'
```

## WebClient

The backend uses Spring WebClient to make HTTP calls to external Pokémon APIs.

WebClient is part of Spring WebFlux and provides a modern, non-blocking way to call external services.

Dependency used:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-webflux'
```

## API Endpoints

### 1. Search Pokémon

Searches for a Pokémon by name and returns its details.

```http
GET /api/pokemon/search?name={pokemonName}
```

Example:

```http
GET /api/pokemon/search?name=pikachu
```

This endpoint is used by the frontend search page to fetch details of a single Pokémon.

### 2. Compare Pokémon

Compares two Pokémon based on their stats and details.

```http
GET /api/pokemon/compare?pokemon1={name1}&pokemon2={name2}
```

Example:

```http
GET /api/pokemon/compare?pokemon1=pikachu&pokemon2=charizard
```

This endpoint is used by the frontend compare page to compare two Pokémon side by side.
