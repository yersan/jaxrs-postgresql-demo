package org.wildfly.s2i.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
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

    @Inject
    private UserTransaction tx;

    @GET
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            tx.begin();
            tasks = em.createNamedQuery(Task.FIND_ALL).getResultList();
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
        return tasks;
    }
}
