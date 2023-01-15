package com.boossang.foreverchildhooddashboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue
    @Column(name = "EVENT_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "EVENT_DATE")
    private LocalDate eventDate;

    @Column(name = "DESCRIPTION")
    private String description;
}
