package com.sixsentix.cda.cdabackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("todos")
public class Todo {
    @Id
    private Integer id;
    private String name;
    private Boolean done;
    private Date date_added;
}
