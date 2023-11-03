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

    public void setUsername(String username) throws Exception {
        if (username.length() > 255) {
            throw new Exception("O campo username deve conter até 255 caracteres");
        }
        this.username = username;

    }

    public void setName(String name) throws Exception {
        if (name.length() > 255) {
            throw new Exception("O campo name deve conter até 255 caracteres");
        }
        this.name = name;
    }

}