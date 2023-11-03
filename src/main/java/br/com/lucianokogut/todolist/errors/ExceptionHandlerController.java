package br.com.lucianokogut.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        System.out.println("Registro de Exception Error [HttpMessageNotReadable]: " + e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Registro de Exception Error [HttpMessageNotReadable]: \n" + e.getMostSpecificCause().getMessage());
    }
}
