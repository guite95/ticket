package com.study.ticket.domain.repository;

import com.study.ticket.domain.Entity.ConcertOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertOptionRepository extends JpaRepository<ConcertOption, Long> {
}
