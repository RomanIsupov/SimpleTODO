package com.example.firstrestful.controller;

import com.example.firstrestful.entity.List;
import com.example.firstrestful.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

    @Autowired
    ListService listService;

    @GetMapping("/lists")
    @ResponseBody
    public java.util.List<List> getLists() {
        return listService.getLists();
    }

    @GetMapping("/lists/{id}")
    @ResponseBody
    public List getList(@PathVariable Integer id) {
        return listService.getList(id);
    }

    @PostMapping("/lists")
    @ResponseBody
    public java.util.List<List> addList(@RequestBody List list) {
        boolean added = listService.addList(list);
        return getLists();
    }

    @DeleteMapping("/lists/{id}")
    @ResponseBody
    public java.util.List<List> deleteList(@PathVariable Integer id) {
        boolean deleted = listService.deleteList(id);
        return getLists();
    }
}
