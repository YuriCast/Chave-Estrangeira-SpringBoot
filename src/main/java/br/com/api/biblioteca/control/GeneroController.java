package br.com.api.biblioteca.control;
import br.com.api.biblioteca.model.Genero;
import br.com.api.biblioteca.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepository;
    @GetMapping
    public List<Genero> listarGenero() {
        return generoRepository.findAll();
    }
    @PostMapping
    public Genero criarGenero(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }

}
