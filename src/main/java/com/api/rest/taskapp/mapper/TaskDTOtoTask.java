package com.api.rest.taskapp.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.api.rest.taskapp.persistence.entities.Task;
import com.api.rest.taskapp.persistence.entities.TaskStatus;
import com.api.rest.taskapp.service.dto.TaskDTO;


@Component
public class TaskDTOtoTask implements IMapper <TaskDTO,Task>{


    @Override
    public Task mapperObject(TaskDTO in) {
        
        Task t = new Task();
        //Tomamos los datos que introduce el usuario de la clase DTO
        t.setTitle(in.getTitle());
        t.setDescription(in.getDescription());
        t.setEndTimeTask(in.getEndTimeTask());
        //Terminamos de rellenar el objeto task 
        t.setCreationTime(LocalDateTime.now());
        t.setFinished(false);
        t.setTaskStatus(TaskStatus.ON_TIME);
        //Retornamos el objeto completo para que el servicio puedo crear el registro en la BBDD
        return t;
    }
    
    
}