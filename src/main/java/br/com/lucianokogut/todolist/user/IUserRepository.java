package br.com.lucianokogut.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Criado a classe de interface que servirá de repositório padrão com os atributos da classe principal
 */
public interface IUserRepository extends JpaRepository<UserModel, UUID>{
    UserModel findByUsername(String username);
    
}
