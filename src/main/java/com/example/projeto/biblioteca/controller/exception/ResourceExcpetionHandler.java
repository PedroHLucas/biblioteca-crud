package com.example.projeto.biblioteca.controller.exception;


import com.example.projeto.biblioteca.dto.exception;
import com.example.projeto.biblioteca.service.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExcpetionHandler {

    @ExceptionHandler(RuntimeException.class) // Quando uma RuntimeException acontecer...
    public ResponseEntity<exception.StandardError> entityNotFounded(RuntimeException e, HttpServletRequest request){

        HttpStatus status =  HttpStatus.NOT_FOUND;
        exception.StandardError err = new exception.StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Não encontrado",
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);

    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<exception.StandardError> resourceNotFounded(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        exception.StandardError err = new exception.StandardError(System.currentTimeMillis(),
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return  ResponseEntity.status(status).body(err);
    }

}
