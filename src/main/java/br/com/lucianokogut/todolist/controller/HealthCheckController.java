package br.com.lucianokogut.todolist.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
// http://localhost:8080/health-check/
public class HealthCheckController {
    @GetMapping("/")
    public ResponseEntity<Object> getRetornoEntity() {
        Map<String, String> retorno = new HashMap<>();
        retorno.put("statusCode", "200");
        retorno.put("resource", "apiToDoList");
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
