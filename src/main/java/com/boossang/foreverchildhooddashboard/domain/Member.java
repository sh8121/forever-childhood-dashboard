package com.boossang.foreverchildhooddashboard.domain;

import com.boossang.foreverchildhooddashboard.constant.Region;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MARRIAGE_YN")
    @Convert(converter = BooleanToYNConverter.class)
    private Boolean isMarried;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "REGION")
    @Enumerated(value = EnumType.STRING)
    private Region region;
}
