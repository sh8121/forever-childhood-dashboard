package com.boossang.foreverchildhooddashboard.service;

import com.boossang.foreverchildhooddashboard.domain.Event;
import com.boossang.foreverchildhooddashboard.repository.EventRepository;
import com.boossang.foreverchildhooddashboard.service.command.CreateEventCommand;
import com.boossang.foreverchildhooddashboard.service.command.UpdateEventCommand;
import com.boossang.foreverchildhooddashboard.service.query.EventDetailQuery;
import com.boossang.foreverchildhooddashboard.service.query.EventSimpleQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    @Transactional(readOnly = true)
    public EventDetailQuery getEventDetail(long eventId) {
        Event event = eventRepository.find(eventId);
        if(event == null)
            throw new IllegalArgumentException("Wrong Info");

        EventDetailQuery eventDetail = new EventDetailQuery();
        eventDetail.setEventId(event.getId());
        eventDetail.setTitle(event.getTitle());
        eventDetail.setEventDate(event.getEventDate());
        eventDetail.setDescription(event.getDescription());

        return eventDetail;
    }

    public long createEvent(CreateEventCommand command) {
        if(command == null ||
            !StringUtils.hasText(command.getTitle()) ||
            command.getEventDate() == null ||
            !StringUtils.hasText(command.getDescription()))
            throw new IllegalArgumentException("Not Enough Info");

        Event event = new Event();
        event.setTitle(command.getTitle());
        event.setEventDate(command.getEventDate());
        event.setDescription(command.getDescription());

        eventRepository.save(event);

        return event.getId();
    }

    public void updateEvent(UpdateEventCommand command) {
        if(command == null ||
            !StringUtils.hasText(command.getDescription()))
            throw new IllegalArgumentException("Not Enough Info");

        Event event = eventRepository.find(command.getEventId());
        if(event == null)
            throw new IllegalArgumentException("Wrong Info");

        event.setDescription(command.getDescription());
    }

    public List<EventSimpleQuery> searchEvent() {
        //TODO Need To Impl
        List<Event> events = eventRepository.findAll();

        List<EventSimpleQuery> result = new ArrayList<>();
        for (Event event : events) {
            EventSimpleQuery eventSimple = new EventSimpleQuery();
            eventSimple.setEventId(event.getId());
            eventSimple.setTitle(event.getTitle());
            eventSimple.setEventDate(event.getEventDate());

            result.add(eventSimple);
        }

        return result;
    }
}
