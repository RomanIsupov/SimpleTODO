package com.example.firstrestful.service;

import com.example.firstrestful.entity.List;
import com.example.firstrestful.entity.Task;

public interface TaskService {

    boolean addTask(Task task);

    boolean deleteTask(Integer taskId);

    void completeTask(Integer taskId);

    java.util.List<Task> getTasks(Integer listId);

    Task getTask(Integer listId, String name);

    Task getTask(Integer id);

    boolean editTask(Integer listId, Integer taskId, Task task);
}
