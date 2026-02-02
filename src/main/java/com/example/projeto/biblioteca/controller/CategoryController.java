package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.entities.Category;
import com.example.projeto.biblioteca.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    //Buscar por todos
    @GetMapping
    public List<Category> listarTodos(){
        return categoryRepository.findAll();
    }

    //Deletar por id
    @PostMapping("/{id}")
    public void deletar(@PathVariable Long id){
        categoryRepository.deleteById(id);
    }

    //Criar uma categoria
    @PostMapping
    public Category criar(@RequestBody Category category){
        return categoryRepository.save(category);
    }

}
