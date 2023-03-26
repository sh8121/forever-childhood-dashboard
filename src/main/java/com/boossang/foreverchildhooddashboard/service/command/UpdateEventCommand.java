package com.boossang.foreverchildhooddashboard.service.command;

import lombok.Data;

@Data
public class UpdateEventCommand {

    private long eventId;
    private String description;
}
