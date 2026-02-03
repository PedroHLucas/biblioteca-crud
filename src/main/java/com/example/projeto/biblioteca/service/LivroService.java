package com.example.projeto.biblioteca.service;

import com.example.projeto.biblioteca.entities.Livro;
import com.example.projeto.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;


    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    //Garantir que o ISBN seja sempre salvo em letras maiúsculas
    public Livro save(Livro livro){
        if(livro.getIsbn() != null){
            livro.setIsbn(livro.getIsbn().toUpperCase());
        }
        return livroRepository.save(livro);
    }

    public void delete(Long id){
        //Verificar se o livro existe antes de deleta-lo
        if(!livroRepository.existsById(id)){
            throw new RuntimeException("Books not found with id : " + id);
        }
        livroRepository.deleteById(id);
    }

}
