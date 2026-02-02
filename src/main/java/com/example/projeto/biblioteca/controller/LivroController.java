package com.example.projeto.biblioteca.controller;


import com.example.projeto.biblioteca.entities.Livro;
import com.example.projeto.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros") // definir url base
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;


    // Listar todos os livros
    @GetMapping
    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

    // Salvar um livro
    @PostMapping
    public Livro criar(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }
}
