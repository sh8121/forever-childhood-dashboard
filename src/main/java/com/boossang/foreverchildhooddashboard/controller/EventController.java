package com.boossang.foreverchildhooddashboard.controller;

import com.boossang.foreverchildhooddashboard.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/addEventForm")
    public String addEventForm() {
        return "event/addEventForm";
    }
}
