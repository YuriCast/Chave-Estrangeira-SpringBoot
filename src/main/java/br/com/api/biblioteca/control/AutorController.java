package br.com.api.biblioteca.control;
import br.com.api.biblioteca.model.Autor;
import br.com.api.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;
    @GetMapping
    public List<Autor> listarAutor() {
        return autorRepository.findAll();
    }
    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

}
