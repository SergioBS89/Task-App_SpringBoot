package com.api.rest.taskapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.rest.taskapp.persistence.entities.Task;
import com.api.rest.taskapp.persistence.entities.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * @param status (enum)
     * @return different task according to their status
     */
    public List<Task> findAllByTaskStatus(TaskStatus status);

    /**
     * @param id
     *           This function marks tasks when they are finished
     */
    @Modifying // This anotation is applied to make a modification query(Update)
    @Query(value = "UPDATE TASK SET FINISHED = true WHERE ID=:id", nativeQuery = true)
    public void markAsFinishedTask(@Param("id") Long id);

}