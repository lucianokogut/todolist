package br.com.lucianokogut.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
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
    @GetMapping("/primeiroMetodo")
     public String primeiraMensagem() {
        return "Funcionou";
    }
}
