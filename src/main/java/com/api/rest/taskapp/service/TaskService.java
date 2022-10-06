package com.api.rest.taskapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.rest.taskapp.exceptions.TaskExceptions;
import com.api.rest.taskapp.mapper.TaskDTOtoTask;
import com.api.rest.taskapp.persistence.entities.Task;
import com.api.rest.taskapp.persistence.entities.TaskStatus;
import com.api.rest.taskapp.persistence.repository.TaskRepository;
import com.api.rest.taskapp.service.dto.TaskDTO;

@Service // Service Bean
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private TaskDTOtoTask mapper;

  /* -------------------------------------------------------------------------- */
  /* CREATING TASK */
  /* -------------------------------------------------------------------------- */
  public Task newTask(TaskDTO t) {

    // Mapeamos el objeto DTO para convertirlo en un Objeto Task
    Task task = mapper.mapperObject(t);

    return taskRepository.save(task);
  }
  /* -------------------------------------------------------------------------- */
  /* SHOWING ALL TASKS */
  /* -------------------------------------------------------------------------- */

  public List<Task> showAll() {

    return taskRepository.findAll();
  }

  /* -------------------------------------------------------------------------- */
  /* SHOWING TASKS ACCORDING TO THEIR STATUS */
  /* -------------------------------------------------------------------------- */

  public List<Task> showByStatus(TaskStatus status) {

    return taskRepository.findAllByTaskStatus(status);
  }

  /* -------------------------------------------------------------------------- */
  /* MARK TASK WHEN IS FINISHED */
  /* -------------------------------------------------------------------------- */

  @Transactional // Anotacion obligatoria para trabajar con la anotacion query de jpa repo..
  public void updateTaskWhenIsFinished(Long id) {

    // If id doesnt exist, launch an own exception
    Optional<Task> optional = taskRepository.findById(id);

    if (optional.isEmpty()) {
      throw new TaskExceptions("Task not found", HttpStatus.NOT_FOUND);
    }
    taskRepository.markAsFinishedTask(id);
  }

  /* -------------------------------------------------------------------------- */
  /* DELETE TASK BY ID */
  /* -------------------------------------------------------------------------- */

  public void deleteTaskById(Long id) {

    // If id doesnt exist, launch an own exception
    Optional<Task> optional = taskRepository.findById(id);
    if (optional.isEmpty()) {
      throw new TaskExceptions("Cannot be deleted..task not found", HttpStatus.NOT_FOUND);
    }
    taskRepository.deleteById(id);
  }

}