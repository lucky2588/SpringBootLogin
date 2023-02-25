package com.example.login.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Page<Course> {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private int totalItems;
    private List<Course> data;

    public Page(int currentPage, int pageSize, int totalPages, int totalItems, List<Course> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.data = data;
    }

    // getters and setters

}