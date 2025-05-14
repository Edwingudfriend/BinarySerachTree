package com.example.binarysearchtree.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Employee implements Comparable<Employee> {
    private final Integer id;
    private String name;
    private String position;

    public Employee(@NotNull Integer id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    @Override
    public int compareTo(@NotNull Employee other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        return this.id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}