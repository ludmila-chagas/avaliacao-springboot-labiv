package br.gov.sp.fatec.springboot3labiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{
    @Query("SELECT j FROM Jogo j WHERE j.estudio = :estudio AND j.titulo LIKE %:titulo%")
List<Jogo> buscarJogosPorTituloEestudio(@Param("estudio") String estudio, @Param("titulo") String titulo);
}
