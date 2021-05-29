package com.example.firstrestful.service;

import com.example.firstrestful.entity.List;
import com.example.firstrestful.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    ListRepository listRepository;

    @Override
    public boolean addList(List list) {
        List listFromDatabase = listRepository.findByName(list.getName());
        if (listFromDatabase != null) {
            return false;
        }
        listRepository.save(list);
        return true;
    }

    @Override
    public boolean deleteList(Integer listId) {
        if (listRepository.findById(listId).isPresent()) {
            listRepository.deleteById(listId);
            return true;
        }
        return false;
    }

    @Override
    public java.util.List<List> getLists() {
        return listRepository.findAll();
    }

    @Override
    public List getList(Integer id) {
        return listRepository.findById(id).orElse(null);
    }
}
