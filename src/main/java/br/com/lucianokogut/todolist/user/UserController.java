package br.com.lucianokogut.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Modificadores das classes podem ser:
 * public - Permite o acesso a qualquer método, atributo ou recursos da classe
 * private - Permite o acesso de forma restritiva aos métodos ou atributos da
 * classe
 * protected - Permite o acesso somente a alguns métodos ou atribuitos
 * pré-definidos
 * 
 * Tipos podem ser:
 * class | enum | interface
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * Tipos dos métodos e seus retornos:
     * String (texto) - Permite uso de frases
     * Integer (int) - Permite uso de números inteiros
     * Double (double) - Permite uso de números com casas decimais
     * Float (float) - Permite uso de números com decimais flutuantes (que variam o
     * tamanho)
     * Char (caracter) - Permite o uso de caracter único
     * Date (data) - Permite o tratamento e o uso de datas
     * void - Permite a realização de algum lógica (regra de negócio) sem retorno do
     * método
     */
    /**
     * 
     * @param userModel pelo body da requisição
     */
    @PostMapping("/")
    public void create(@RequestBody UserModel userModel) {
        System.out.println(userModel.name);
    }
}
