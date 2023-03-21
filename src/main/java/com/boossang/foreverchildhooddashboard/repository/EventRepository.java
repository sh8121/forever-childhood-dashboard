package com.boossang.foreverchildhooddashboard.repository;

import com.boossang.foreverchildhooddashboard.domain.Event;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class EventRepository {

    private final EntityManager entityManager;

    public EventRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event event) {
        entityManager.persist(event);
    }

    public Event find(long eventId) {
        return entityManager.find(Event.class, eventId);
    }

    public List<Event> findAll() {
        return entityManager.createQuery("select e from Event e", Event.class)
                .getResultList();
    }

    public void delete(Event event) {
        entityManager.remove(event);
    }
}
