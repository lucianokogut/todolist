package br.com.lucianokogut.todolist.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeira-rota")
// http://localhost:8080/-------
public class MinhaPrimeiraController {

    /** Métodos de acesso do HTTP (verbos de ação a cada request / response)
     * GET - Buscar uma informação
     * POST - Adicionar um dado ou informação
     * PUT - Alterar um dado ou informação
     * DELETE - Remover um dado ou informação
     * PATCH - Alterar somente parte de um dado ou informação
     */
    // Método (funcionalidade) de uma classe
    @GetMapping("/primeiro-metodo")
     public String primeiraMensagem() {
        return "Funcionou";
    }

    @GetMapping("/data-mock")
    public ResponseEntity<Object> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("campoID", "1");
        data.put("descricao", "Descrição do campo 1");
        data.put("campoID", "2");
        data.put("descrição", "Descrição do campo 2");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/data-string")
    public String dataString() {
        return "campoID: 1, descricao: Descrição do campo 1; campoID: 2, descricao: Descrição do campo 2";
    }
    
}