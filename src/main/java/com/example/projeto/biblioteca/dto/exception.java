package com.example.projeto.biblioteca.dto;

public class exception {

    public record StandardError(Long timestamp, Integer status, String error, String message, String path) {
    }
}
