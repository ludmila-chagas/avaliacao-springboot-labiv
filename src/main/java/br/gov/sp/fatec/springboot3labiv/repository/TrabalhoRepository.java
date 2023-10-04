package br.gov.sp.fatec.springboot3labiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.springboot3labiv.entity.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>{

    @Query("SELECT t FROM Trabalho t WHERE t.titulo LIKE %:titulo% AND t.nota > :nota")
    List<Trabalho> buscarTrabalhosPorTituloENota(@Param("titulo") String titulo, @Param("nota") Integer nota);
}