package com.example.picpay.Exception;

import com.example.picpay.Dto.ExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TreatedExceptions{

   @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity treatDuplicationEntry(DataIntegrityViolationException exception){
       ExceptionDto exceptionDto = new ExceptionDto("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDto);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treatEntityNotFound(EntityNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity treatedGeneralException(Exception exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDto);
    }

}
