package cl.cesarg.prueba.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokedexService implements IService {

    // Inyección de dependencia de la clase RestTemplate
    private final RestTemplate restTemplate;

    // Constructor de la clase
    public PokedexService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // método que obtiene el contenido de ser servicio REST https://pokeapi.co/api/v2/pokemon/
    public String getPokemons(Integer offset, Integer limit) {
        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = 20;
        }
        String url = "https://pokeapi.co/api/v2/pokemon/?offset=" + offset + "&limit=" + limit;
        return restTemplate.getForObject(url, String.class);
    }

    // método que obtiene el contenido de ser servicio REST https://pokeapi.co/api/v2/pokemon/{name}
    public String getPokemon(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        return restTemplate.getForObject(url, String.class);
    }

}
