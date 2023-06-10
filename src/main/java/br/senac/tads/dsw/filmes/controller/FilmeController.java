package br.senac.tads.dsw.filmes.controller;

import br.senac.tads.dsw.filmes.dto.FilmeDTO;
import br.senac.tads.dsw.filmes.model.Filme;
import br.senac.tads.dsw.filmes.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("filmes")
public class FilmeController {

    @Autowired
    private FilmesRepository repository;

    @GetMapping
    public String getFilmes(Model model){
        List<Filme> filmes = repository.findAll();
        model.addAttribute("filmes", filmes);
        return "filmes/lista-filmes";
    }

    @GetMapping("/incluir")
    public String paginaIncluirFilme() {
        return "filmes/formulario";
    }

    @PostMapping
    public String incluirFilme(@Validated FilmeDTO filmeDTO, BindingResult result) {
        if(result.hasErrors()) {
            return "filmes/formulario";
        }

        Filme filme = filmeDTO.toFilme();
        repository.save(filme);

        return "redirect:/lista-filmes";
    }

}
