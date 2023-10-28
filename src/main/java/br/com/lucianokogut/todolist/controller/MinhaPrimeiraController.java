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

    /**
     * Métodos de acesso do HTTP (verbos de ação a cada request / response)
     * GET - Buscar uma informação
     * POST - Adicionar um dado ou informação
     * PUT - Alterar um dado ou informação
     * DELETE - Remover um dado ou informação
     * PATCH - Alterar somente parte de um dado ou informação
     * 
     * Método (funcionalidade) de uma classe
     */
    @GetMapping("/primeiro-metodo")
    public String primeiraMensagem() {
        return "Funcionou";
    }

    @GetMapping("/data-mock")
    public ResponseEntity<Object> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("campo-1", "1");
        data.put("descricao-1", "Descrição do campo 1");
        data.put("campo-2", "2");
        data.put("descrição-2", "Descrição do campo 2");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/data-string")
    public String dataString() {
        return "campo-1: 1, descricao-1: Descrição do campo 1; campo-2: 2, descricao-2: Descrição do campo 2";
    }

    @GetMapping("/about")
    public String mensagemAbout() {
        return "Esta é a mensagem da área 'Sobre' que todo sistema deveria ter...";
    }

}