package br.com.api.biblioteca.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "Livro")
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String paginas;
    private String anoPublicacao;

    @ManyToOne
    private Autor autor;


    @ManyToOne
    private Genero genero;
}
