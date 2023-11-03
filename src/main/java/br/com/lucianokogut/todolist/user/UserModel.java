package br.com.lucianokogut.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * Métodos para Get e Set (getters e setters)
     * gerados pela biblioteca do Lombok pelas Annotation's
     * @Data, @Getter e @Setter
     */

    public void setAllFields(String username, String name, String password) throws Exception {
        if (username.length() > 255 || name.length() > 255 || password.length() > 255) {
            throw new Exception("Os campos do tipo String devem conter até 255 caracteres");
        }
        this.username = username;
        this.name = name;
        this.password = password;

    }

}