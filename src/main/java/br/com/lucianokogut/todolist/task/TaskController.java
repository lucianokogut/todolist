package br.com.lucianokogut.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucianokogut.todolist.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {

        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);
        System.out.println("Chegou no controller... " + idUser);

        var task = this.taskRepository.save(taskModel);

        var currentDate = LocalDateTime.now();
        /**
         * Verifica se a data de início da tarefa é válida (depois da data atual)
         * e se a data de término é após a data de início (intervalo válido)
         */
        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Na tarefa \n" + task
                            + " \n a data de início ou de término deve ser maior do que a data atual...");
        }

        /**
         * Verifica se a data de término é após a data de início (intervalo válido)
         */
        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A tarefa \n" + task.getId() + " com início em " + task.getStartAt() + " e término em "
                            + task.getEndAt() + " \n deve ter a data de início menor do que a data de término!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("A tarefa \n" + task + " \n foi inserida com sucesso!");
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIdUser((UUID) idUser);
        return tasks;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id) {

        var idUser = request.getAttribute("idUser");

        var task = this.taskRepository.findById(id).orElse(null);

        if (task == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Tarefa não encontrada!");
        }

        if (!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuário " + idUser + " não tem permissão para alterar esta tarefa!");
        }

        Utils.copyNonNullProperties(taskModel, task);

        var taskUpdated = this.taskRepository.save(task);
        System.out.println("A tarefa \n" + task + " \n do usuário " + idUser + " foi alterada de forma correta!");

        return ResponseEntity.status(HttpStatus.OK)
                .body("A tarefa \n" + task + " \n do usuário " + idUser + " foi alterada de forma correta!");

    }

}
