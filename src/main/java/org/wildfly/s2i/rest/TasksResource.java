package org.wildfly.s2i.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.wildfly.s2i.model.Task;

@Path("tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TasksResource {

    @PersistenceContext
    private EntityManager em;

    @GET
    public List<Task> getAllTasks() {
        return em.createNamedQuery(Task.FIND_ALL).getResultList();
    }
}
