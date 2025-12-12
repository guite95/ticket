package com.study.ticket.domain.dto.response;

import com.study.ticket.domain.Entity.ConcertOption;

import java.time.LocalDateTime;

public record ConcertOptionResponse(Long concertOptionId, LocalDateTime date) {
    public static ConcertOptionResponse from(ConcertOption concertOption) {
        return new ConcertOptionResponse(concertOption.getId(), concertOption.getStartTime());
    }
}
