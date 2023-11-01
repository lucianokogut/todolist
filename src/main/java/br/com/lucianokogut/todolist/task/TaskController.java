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
         */
        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Na tarefa " + task
                            + " \n a data de início ou de término deve ser maior do que a data atual...");
        }

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A tarefa " + task.getId() + " com início em " + task.getStartAt() + " e término em "
                            + task.getEndAt() + " \n deve ter a data de início menor do que a data de término!");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("A tarefa " + task + " \n foi inserida com sucesso!");
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIdUser((UUID) idUser);
        return tasks;
    }

    @PutMapping("/{id}")
    public TaskModel update(@RequestBody TaskModel taskModel, HttpServletRequest request, @PathVariable UUID id) {

        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);
        taskModel.setId((UUID) id);
        var task = this.taskRepository.save(taskModel);
        //return ResponseEntity.status(HttpStatus.OK)
        //        .body("A tarefa " + task + " \n foi inserida com sucesso!");
        return task;
    }

}
