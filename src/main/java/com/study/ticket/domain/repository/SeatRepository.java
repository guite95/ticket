package com.study.ticket.domain.repository;

import com.study.ticket.domain.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
