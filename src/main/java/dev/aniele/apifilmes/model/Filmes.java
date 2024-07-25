package dev.aniele.apifilmes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "filme")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String autor;
    private String genero;
    private String descricao;



}
