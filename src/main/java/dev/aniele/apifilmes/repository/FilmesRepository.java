package dev.aniele.apifilmes.repository;

import dev.aniele.apifilmes.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long> {


}
