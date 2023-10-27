package com.boossang.foreverchildhooddashboard.controller;

import com.boossang.foreverchildhooddashboard.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/add-event-form")
    public String addEventForm() {
        return "event/addEventForm";
    }

    @GetMapping("/event-list")
    public String eventList(Model model) {
        var eventList = eventService.searchEvent();
        model.addAttribute("eventList", eventList);
        return "event/eventList";
    }
}
