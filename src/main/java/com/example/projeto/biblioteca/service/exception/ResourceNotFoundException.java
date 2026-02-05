package com.example.projeto.biblioteca.service.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Recurso não encontrado pelo ID :" +id);
    }



}
