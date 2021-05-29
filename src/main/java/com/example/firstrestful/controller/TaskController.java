package com.example.firstrestful.controller;

import com.example.firstrestful.entity.Task;
import com.example.firstrestful.service.ListService;
import com.example.firstrestful.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    ListService listService;

    @GetMapping("/lists/{id}/tasks")
    @ResponseBody
    public java.util.List<Task> getTasks(@PathVariable(name = "id") Integer listId) {
        return taskService.getTasks(listId);
    }

    @GetMapping("/lists/{listId}/tasks/{taskId}")
    @ResponseBody
    public Task getTask(@PathVariable(name = "listId") Integer listId,
                        @PathVariable(name = "taskId") Integer taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping("/lists/{listId}/tasks")
    @ResponseBody
    public java.util.List<Task> addTask(@PathVariable(name = "listId") Integer listId,
                                        @RequestBody Task task) {
        task.setList(listService.getList(listId));
        taskService.addTask(task);
        return getTasks(listId);
    }

    @DeleteMapping("/lists/{listId}/tasks/{taskId}")
    @ResponseBody
    public java.util.List<Task> deleteTask(@PathVariable(name = "listId") Integer listId,
                                           @PathVariable(name = "taskId") Integer taskId) {
        taskService.deleteTask(taskId);
        return getTasks(listId);
    }

    @PatchMapping("/lists/{listId}/tasks/{taskId}")
    @ResponseBody
    public java.util.List<Task> editTask(@PathVariable(name = "listId") Integer listId,
                                         @PathVariable(name = "taskId") Integer taskId,
                                         @RequestBody Task task) {
        boolean edited = taskService.editTask(listId, taskId, task);
        return getTasks(listId);
    }
}
