package br.com.api.biblioteca.repository;
import br.com.api.biblioteca.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
