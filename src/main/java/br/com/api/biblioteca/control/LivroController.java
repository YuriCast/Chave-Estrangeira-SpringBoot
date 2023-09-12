package br.com.api.biblioteca.control;
import br.com.api.biblioteca.model.Livro;
import br.com.api.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }
    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable String id) {
        try {
            livroRepository.deleteById(id);
            return ResponseEntity.ok("Livro deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable String id, @RequestBody Livro livroAtualizado) {
        if (livroRepository.existsById(id)) {
            Livro livro = livroRepository.findById(id).get();
            livro.setId(livroAtualizado.getId());
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setPaginas(livroAtualizado.getPaginas());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setAutor(livroAtualizado.getAutor());
            livro.setGenero(livroAtualizado.getGenero());
            Livro livroAtualizadoBD = livroRepository.save(livro);
            return ResponseEntity.ok(livroAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
