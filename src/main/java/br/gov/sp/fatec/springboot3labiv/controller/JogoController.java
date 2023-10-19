package br.gov.sp.fatec.springboot3labiv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3labiv.entity.Jogo;
import br.gov.sp.fatec.springboot3labiv.service.JogoService;

@RestController
@RequestMapping(value = "/jogo")
@CrossOrigin
public class JogoController {
    
    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<Jogo> buscarTodos(){
        return jogoService.buscarTodos();
    }

    @PostMapping
    public Jogo salvar(@RequestBody Jogo jogo){
        return jogoService.salvar(jogo);
    }

    @GetMapping("/{estudio}/{titulo}")
    public List<Jogo> buscarJogosPorTituloEestudio(@PathVariable("estudio") String estudio, @PathVariable("titulo") String titulo) {
        return jogoService.buscarJogosPorTituloEestudio(estudio, titulo);
    }
}
