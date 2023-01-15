package com.boossang.foreverchildhooddashboard.domain;

import com.boossang.foreverchildhooddashboard.constant.GameKind;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "GAME_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID")
    private Event event;

    @Column(name = "GAME_KIND")
    @Enumerated(EnumType.STRING)
    private GameKind gameKind;

    @Column(name = "DESCRIPTION")
    private String description;
}
