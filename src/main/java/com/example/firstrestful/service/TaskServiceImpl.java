package com.example.firstrestful.service;

import com.example.firstrestful.entity.List;
import com.example.firstrestful.entity.Task;
import com.example.firstrestful.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public boolean addTask(Task task) {
        Task taskFromDatabase = taskRepository.findByNameAndListId(task.getName(), task.getList().getId());
        if (taskFromDatabase != null) {
            return false;
        }
        taskRepository.save(task);
        return true;
    }

    @Override
    public boolean deleteTask(Integer taskId) {
        if (taskRepository.findById(taskId).isPresent()) {
            taskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }

    @Override
    public void completeTask(Integer taskId) {
        taskRepository.completeTask(taskId);
    }

    @Override
    public java.util.List<Task> getTasks(Integer listId) {
        return taskRepository.findAllByListId(listId);
    }

    @Override
    public Task getTask(Integer listId, String name) {
        return taskRepository.findByNameAndListId(name, listId);
    }

    @Override
    public Task getTask(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public boolean editTask(Integer listId, Integer taskId, Task task) {
        taskRepository.updateTask(taskId, task.getName(), task.getCompleted());
        return true;
    }
}
