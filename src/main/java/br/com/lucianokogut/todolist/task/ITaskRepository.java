package br.com.lucianokogut.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Criado a classe de interface que servirá de repositório padrão com os atributos da classe principal
 */
public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
    
}
