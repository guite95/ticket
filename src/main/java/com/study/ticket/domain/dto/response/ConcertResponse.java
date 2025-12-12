package com.study.ticket.domain.dto.response;

import com.study.ticket.domain.Entity.Concert;


public record ConcertResponse(Long concertId, String name) {
    public static ConcertResponse from(Concert concert) {
        return new ConcertResponse(concert.getId(), concert.getConcertTitle());
    }
}
