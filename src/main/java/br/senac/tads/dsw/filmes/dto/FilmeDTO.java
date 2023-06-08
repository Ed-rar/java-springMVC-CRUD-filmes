package br.senac.tads.dsw.filmes.dto;

import br.senac.tads.dsw.filmes.model.Filme;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FilmeDTO {

    /**
     * DTO criado para realizar as validações necessarias para criar um filme
     */

    @NotBlank
    private String titulo;
    @NotBlank
    private String genero;
    @NotNull
    private Integer anoLancamento = null;

    public FilmeDTO() {
    }

    public FilmeDTO(String titulo, String genero, Integer anoLancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Filme toFilme() {
        Filme filme = new Filme();
        filme.setTitulo(this.titulo);
        filme.setGenero(this.genero);
        filme.setAnoLancamento(this.anoLancamento);
        return filme;
    }
}
