package com.example.firstrestful.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "boolean default false")
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private List list;

    public Task() { }

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, List list) {
        this.name = name;
        this.list = list;
    }
}
