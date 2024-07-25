package dev.aniele.apifilmes.controller;

import dev.aniele.apifilmes.model.Filmes;
import dev.aniele.apifilmes.service.FilmesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @Operation(tags = "Cadastro", summary = "Adicionar filme", description = "Esse método serve para adicionar filmes")
    @PostMapping("/adicionar")
    public ResponseEntity<Filmes> adicionarFilme(@RequestBody Filmes filmes){
        Filmes filmeParaSerAdicionado = filmesService.adicionarFilme(filmes);
        return new ResponseEntity<>(filmeParaSerAdicionado, HttpStatus.CREATED);
    }

    @Operation(tags = "Cadastro", summary = "Ver todos os filmes", description = "Esse método serve para ver todos os filmes")
    @GetMapping("/todos")
    public ResponseEntity<List<Filmes>> buscarTodosFilmes(){
        List<Filmes> todosFilmes = filmesService.buscarTodosFilmes();
        return new ResponseEntity<>(todosFilmes, HttpStatus.OK);
    }

    @Operation(tags = "Cadastro", summary = "Buscar filme por id", description = "Esse método serve para buscar um filme pelo seu id")
    @GetMapping("/item/{id}")
    public ResponseEntity<?> buscarFilmePorId(@PathVariable Long id){
        Optional<Filmes> filmeBuscadoPorId = filmesService.buscarFilmePorId(id);
        if(filmeBuscadoPorId.isPresent()) {
            return new ResponseEntity<>(filmeBuscadoPorId.get(), HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado com o id: " + id);
        }
    }

    @Operation(tags = "Cadastro", summary = "Deletar filme", description = "Esse método serve para deletar filmes")
    @DeleteMapping("/deletar/{id}")
    public void deletarFilmePorId(@PathVariable Long id){
        filmesService.deletarFilme(id);
    }

    @Operation(tags = "Cadastro", summary = "Atualizar filme", description = "Esse método serve para atualizar filmes")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Filmes> atualizarFilme(@PathVariable Long id, @RequestBody Filmes filme){
        try{
            Optional<Filmes> filmeParaAtualizar = filmesService.atualizarFilme(id, filme);
            return new ResponseEntity<>(filmeParaAtualizar.orElse(null), HttpStatus.OK);
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
