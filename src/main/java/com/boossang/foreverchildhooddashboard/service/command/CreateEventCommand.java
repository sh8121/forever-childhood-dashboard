package com.boossang.foreverchildhooddashboard.service.command;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateEventCommand {

    private String title;
    private LocalDate eventDate;
    private String description;
}
