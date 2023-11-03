package br.com.lucianokogut.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    /**
     * 
     * ID - Código da tarefa cadastrada gerada automaticamente (UUID)
     * Usuário (ID_Usuario) - Código do usuário responsável por aquela tarefa
     * (vincular) este usuário com o cadastro da tb_users
     * Título - Título da tarefa limitando a uma quantidade de 60 caracteres
     * Descrição - Descrição mais detalhada da tarefa limitando a 255 caracteres
     * Data de Início - Data de início da tarefa
     * Data de Término - Data de término da tarefa
     * Prioridade - Padrão de prioridade definido como Alta, Baixa, Média, Muito Alta
     * sendo limitado a até 25 caracteres
     * Criado Em - Data e hora da criação do registro da tarefa na tabela
     */

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 60)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    @Column(length = 25)
    private String priority;

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setDescription(String description) throws Exception {
        if(description.length() > 255) {
            throw new Exception("O campo description deve conter até 255 caracteres");
        }
        this.description = description;
    }

    public void setTitle(String title) throws Exception {
        if(title.length() > 60) {
            throw new Exception("O campo title deve conter até 60 caracteres");
        }
        this.title = title;
    }

    public void setPriority(String priority) throws Exception {
        if(priority.length() > 25) {
            throw new Exception("O campo priority deve conter até 25 caracteres");
        }
        this.priority = priority;
    }

}