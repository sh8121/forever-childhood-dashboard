package com.boossang.foreverchildhooddashboard.service.query;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventSimpleQuery {

    private long eventId;
    private String title;
    private LocalDate eventDate;
}
