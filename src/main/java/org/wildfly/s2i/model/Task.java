package org.wildfly.s2i.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
@NamedQuery(name = Task.FIND_ALL, query = "SELECT t FROM Task t")
public class Task implements Serializable {
    public static final String FIND_ALL = "org.wildfly.s2i.Task.ALL";

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    public Task() {}

    public Task(String title) {
        super();
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
