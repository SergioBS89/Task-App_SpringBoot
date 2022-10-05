package com.api.rest.taskapp.persistence.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data //Generates implicitly getters and setters and constructors
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime creationTime;
    private LocalDateTime endTimeTask;
    private boolean finished;
    private TaskStatus taskStatus;
}