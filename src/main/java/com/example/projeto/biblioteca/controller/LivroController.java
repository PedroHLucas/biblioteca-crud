package com.example.projeto.biblioteca.controller;


import com.example.projeto.biblioteca.dto.LivroDTO;
import com.example.projeto.biblioteca.entities.Livro;
import com.example.projeto.biblioteca.repository.LivroRepository;
import com.example.projeto.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros") // definir url base
public class LivroController {



    @Autowired
    private LivroService livroService;


    // Listar todos os livros
    @GetMapping
    public List<LivroDTO> listarTodos(){
        List<Livro> livros = livroService.findAll();

        return livros.stream()
                .map(LivroDTO::new)
                .toList();
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
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.update(id, livro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> buscarPorId(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        LivroDTO dto = new LivroDTO(livro);
        return ResponseEntity.ok().body(dto);
    }
}
