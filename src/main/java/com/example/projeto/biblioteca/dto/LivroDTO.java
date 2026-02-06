package com.example.projeto.biblioteca.dto;

import com.example.projeto.biblioteca.entities.Livro;

public record LivroDTO(Long id, String title, String autor, String categoriaNome) {

    public LivroDTO(Livro livro){
        this(livro.getId(), livro.getTitle(), livro.getAutor(), livro.getCategoria() != null ? livro.getCategoria().getNome() : "Sem categoria ");
    }
}
