package com.api.rest.taskapp.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.taskapp.persistence.entities.Task;
import com.api.rest.taskapp.persistence.entities.TaskStatus;
import com.api.rest.taskapp.service.TaskService;
import com.api.rest.taskapp.service.dto.TaskDTO;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    /* -------------------------------------------------------------------------- */
    /* POST TO CREATE */
    /* -------------------------------------------------------------------------- */
    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) {

        return taskService.newTask(taskDTO);
    }
    /* -------------------------------------------------------------------------- */
    /* GET TO SHOW ALL */
    /* -------------------------------------------------------------------------- */

    @GetMapping("/all")
    public List<Task> showAll() {

        return taskService.showAll();
    }

    /* -------------------------------------------------------------------------- */
    /* GET TO SHOW BY STATUS */
    /* -------------------------------------------------------------------------- */

    @GetMapping("/status/{status}")
    public List<Task> showByStatus(@PathVariable TaskStatus status) {

        return taskService.showByStatus(status);
    }

    /* -------------------------------------------------------------------------- */
    /* PUT TO UPDATE FINISH STATUS */
    /* -------------------------------------------------------------------------- */

    @PutMapping("/mark/{id}")
    public ResponseEntity<Void> markStatusTask(@PathVariable Long id) {

        taskService.updateTaskWhenIsFinished(id);
        return ResponseEntity.noContent().build();
    }

    /* -------------------------------------------------------------------------- */
    /* DELETE TASK */
    /* -------------------------------------------------------------------------- */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {

        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

}