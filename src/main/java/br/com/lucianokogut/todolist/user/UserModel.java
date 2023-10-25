package br.com.lucianokogut.todolist.user;

import lombok.Data;

@Data
public class UserModel {

    private String username;
    private String name;
    private String password;

    /**
     * Métodos para Get e Set (getters e setters)
     * gerados pela biblioteca do Lombok pelas Annotation's
     * @Data, @Getter e @Setter
     */

}