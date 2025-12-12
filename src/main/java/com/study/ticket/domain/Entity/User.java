package com.study.ticket.domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "points", columnDefinition = "int default 0")
    private Long points = 0L;

    public void chargePoint(Long amount) {
        this.points += amount;
    }

    public void usePoint(Long amount) {
        this.points -= amount;
    }
}

