package com.sixsentix.cda.cdabackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Table("todos")
public class Todo {
    @Id
    private Integer id;
    private String name;
    private Boolean done;
    @Column("date_added")
    @JsonProperty("date_added")
    private Date dateAdded;
    private Integer severity;
}
