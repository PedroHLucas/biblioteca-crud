package com.example.projeto.biblioteca.controller;


import com.example.projeto.biblioteca.entities.Livro;
import com.example.projeto.biblioteca.repository.LivroRepository;
import com.example.projeto.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros") // definir url base
public class LivroController {



    @Autowired
    private LivroService livroService;


    // Listar todos os livros
    @GetMapping
    public List<Livro> listarTodos(){
        return livroService.findAll();
    }

    // Salvar um livro
    @PostMapping
    public Livro criar(@RequestBody Livro livro){
        return livroService.save(livro);
    }
    // Deletar um livro
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        livroService.delete(id);
    }
}
