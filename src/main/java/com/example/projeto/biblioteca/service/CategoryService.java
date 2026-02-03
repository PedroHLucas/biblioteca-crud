package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.entities.Category;
import com.example.projeto.biblioteca.entities.Livro;
import com.example.projeto.biblioteca.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    //Categorias serem salvas em letras maiusculas
    public Category save(Category category){
        if(category.getNome() != null){
            category.setNome(category.getNome().toUpperCase());
        }
        return  categoryRepository.save(category);
    }

    public void delete(Long id){

        if(!categoryRepository.existsById(id)){
            throw new RuntimeException("Category not found whit id :" + id);
        }
        categoryRepository.deleteById(id);
    }

}
