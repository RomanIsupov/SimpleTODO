package com.example.firstrestful.service;

import com.example.firstrestful.entity.List;

public interface ListService {

    boolean addList(List list);

    boolean deleteList(Integer listId);

    //boolean editList(List list);

    java.util.List<List> getLists();

    List getList(Integer id);
}
