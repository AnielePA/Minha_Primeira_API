package dev.aniele.apifilmes.service;

import dev.aniele.apifilmes.model.Filmes;
import dev.aniele.apifilmes.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    @Autowired
    FilmesRepository filmesRepository;

    public Filmes adicionarFilme(Filmes filmes) {
        if (filmes == null) {
            throw new NullPointerException("O objeto Filmes não pode ser nulo");
        }
        return filmesRepository.save(filmes);
    }

    public List<Filmes> buscarTodosFilmes() {
        return filmesRepository.findAll();
    }

    public Optional<Filmes> buscarFilmePorId(Long id) {
        if (id == null) {
            throw new NullPointerException("O id não pode ser nulo");
        }
        return filmesRepository.findById(id);
    }

    public void deletarFilme(Long id) {
        if (id == null) {
            throw new NullPointerException("O id não pode ser nulo");
        }
        filmesRepository.deleteById(id);
    }

    public Optional<Filmes> atualizarFilme(Long id, Filmes filmes) {
        if (id == null) {
            throw new NullPointerException("O id não pode ser nulo");
        }
        if (filmes == null) {
            throw new NullPointerException("O objeto Filmes não pode ser nulo");
        }
        Optional<Filmes> filmeBuscadoParaAtualizar = filmesRepository.findById(id);
        if (filmeBuscadoParaAtualizar.isPresent()) {
            Filmes filmeAtualizar = filmeBuscadoParaAtualizar.get();
            if (filmes.getNome() != null) {
                filmeAtualizar.setNome(filmes.getNome());
            }
            if (filmes.getAutor() != null) {
                filmeAtualizar.setAutor(filmes.getAutor());
            }
            if (filmes.getGenero() != null) {
                filmeAtualizar.setGenero(filmes.getGenero());
            }
            if (filmes.getDescricao() != null) {
                filmeAtualizar.setDescricao(filmes.getDescricao());
            }
            return Optional.of(filmeAtualizar);
        }
        else {
            throw new RuntimeException("Não foi encontrado um filme com esse id");
        }
    }

}