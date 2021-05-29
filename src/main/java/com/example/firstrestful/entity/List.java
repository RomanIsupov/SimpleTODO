package com.example.firstrestful.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lists")
@Getter
@Setter
@JsonIgnoreProperties("tasks")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "list")
    private java.util.List<Task> tasks;

    public List() { }

    public List(String name) {
        this.name = name;
    }
}
