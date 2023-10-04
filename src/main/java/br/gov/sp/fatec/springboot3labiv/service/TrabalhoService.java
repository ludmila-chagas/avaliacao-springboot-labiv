package br.gov.sp.fatec.springboot3labiv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.springboot3labiv.entity.Trabalho;
import br.gov.sp.fatec.springboot3labiv.repository.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<Trabalho> buscarTodos(){
        return trabalhoRepository.findAll();
    }

    public Trabalho salvar(Trabalho trabalho){
        return trabalhoRepository.save(trabalho);
    }

    public Trabalho buscarPorId(Long id){
        Optional<Trabalho> trabalhoEncontrado = trabalhoRepository.findById(id);
        if(trabalhoEncontrado.isEmpty()){
            throw new IllegalArgumentException("Trabalho não encontrado!");
        }
        return trabalhoEncontrado.get();
    }

    public List<Trabalho> buscarTrabalhosPorTituloENota(String titulo, Integer nota){
        return trabalhoRepository.buscarTrabalhosPorTituloENota(titulo, nota);
    }
}
