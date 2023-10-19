package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;
import br.gov.sp.fatec.springboot3labiv.repository.JogoRepository;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> buscarTodos(){
        return jogoRepository.findAll();
    }

    public Jogo salvar(Jogo jogo){
        if(jogo == null || jogo.getTitulo() == null || jogo.getTitulo().isBlank() ||
            jogo.getEstudio() == null || jogo.getEstudio().isBlank() ||
            jogo.getLancamento() == null){
            throw new IllegalArgumentException("jogo com atributos inválidos!");
        }
        return jogoRepository.save(jogo);
    }

    public List<Jogo> buscarJogosPorTituloEestudio(String estudio, String titulo){
        return jogoRepository.buscarJogosPorTituloEestudio(estudio, titulo);
    }
}