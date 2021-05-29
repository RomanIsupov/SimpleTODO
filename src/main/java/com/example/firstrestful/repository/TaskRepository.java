package com.example.firstrestful.repository;

import com.example.firstrestful.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByName(String name);

    @Query("FROM Task WHERE name = :name AND list.id = :listId")
    Task findByNameAndListId(@Param(value = "name") String name, @Param(value = "listId") Integer listId);

    @Query("FROM Task WHERE list.id = :listId")
    java.util.List<Task> findAllByListId(@Param(value = "listId") Integer listId);

    @Modifying
    @Query("UPDATE Task t SET t.completed = TRUE WHERE t.id = :id")
    void completeTask(@Param(value = "id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Task t SET t.name = :name, t.completed = :completed WHERE t.id = :taskId")
    void updateTask(@Param(value = "taskId") Integer taskId,
                    @Param(value = "name") String name,
                    @Param(value = "completed") Boolean completed);
}
