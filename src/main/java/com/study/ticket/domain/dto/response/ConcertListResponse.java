package com.study.ticket.domain.dto.response;

import com.study.ticket.domain.Entity.Concert;

import java.util.List;

public record ConcertListResponse(List<ConcertResponse> concerts) {
    public static ConcertListResponse from(List<Concert> concerts) {
        return new ConcertListResponse(concerts.stream().map(ConcertResponse::from).toList());
    }
}
