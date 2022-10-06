package com.api.rest.taskapp.service.dto;

import java.time.LocalDateTime;

import lombok.Data;

//SUB CLASE ENCARGADA DE AGREGAR LOS DATOS NECESARIOS PARA CREAR UN NUEVO REGISTRO

// Se omiten ciertos datos de la clase original (id, fecha de creacion, fecha finalizacion tarea...)

@Data
public class TaskDTO {
    
    private Long id;

    private String title;
    private String description;   
    private LocalDateTime endTimeTask;
    
  
}