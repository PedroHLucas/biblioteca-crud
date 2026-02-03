package com.example.projeto.biblioteca.controller;

import com.example.projeto.biblioteca.entities.Category;
import com.example.projeto.biblioteca.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //Buscar por todos
    @GetMapping
    public List<Category> listarTodos(){
        return categoryService.findAll();
    }

    //Deletar por id
    @PostMapping("/{id}")
    public void deletar(@PathVariable Long id){
        categoryService.delete(id);
    }

    //Criar uma categoria
    @PostMapping
    public Category criar(@RequestBody Category category){
        return categoryService.save(category);
    }

}
