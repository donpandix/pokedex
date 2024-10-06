package cl.cesarg.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.cesarg.prueba.model.Pokemon;
import cl.cesarg.prueba.model.PokemonResponse;
import cl.cesarg.prueba.service.PokedexService;


@Controller
public class HomeController implements IController {

    @Autowired
    private PokedexService pokedexService;

    @Autowired
    private ObjectMapper objectMapper;

    // Método que retorna la vista home
    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(required = false, defaultValue = "0") Integer offset,
                       @RequestParam(required = false, defaultValue = "30") Integer limit) {

        // Obtiene la lista de pokemones
        String retorno = pokedexService.getPokemons(offset, limit);
        int count = 0;
        
        try {
            // envia la lista de elementos
            PokemonResponse pokemonResponse = objectMapper.readValue(retorno, PokemonResponse.class);
            count = pokemonResponse.getCount();

            pokemonResponse.getResults().forEach(pokemon -> {
                try {
                    String pokemonData = pokedexService.getPokemon(pokemon.getName());
                    Pokemon pokemonDetail = objectMapper.readValue(pokemonData, Pokemon.class);
                    pokemon.setSprites(pokemonDetail.getSprites());
                    pokemon.setHeight(pokemonDetail.getHeight() / 10);
                    pokemon.setWeight(pokemonDetail.getWeight() / 10);
                    pokemon.setBaseExperience(pokemonDetail.getBaseExperience());
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("error", "Error al obtener los pokemones");
                }
            });

            model.addAttribute("pokemonList", pokemonResponse.getResults());
            model.addAttribute("count", count);
            model.addAttribute("totalPages", Math.ceil(count / limit));
            model.addAttribute("offset", offset);
            model.addAttribute("limit", limit);
            model.addAttribute("linkPaginaSiguiente", "./?offset=" + (offset + limit) + "&limit=" + limit);
            model.addAttribute("linkPaginaAnterior", "./?offset=" + (offset - limit) + "&limit=" + limit);


        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error al obtener los pokemones");
        }
        // Retorna un mensaje
        model.addAttribute("message", "POKEDEX");
        return "home";
    }

    
}
