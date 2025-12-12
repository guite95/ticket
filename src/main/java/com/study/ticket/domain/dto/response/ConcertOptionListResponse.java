package com.study.ticket.domain.dto.response;

import com.study.ticket.domain.Entity.ConcertOption;

import java.util.List;

public record ConcertOptionListResponse(List<ConcertOptionResponse> concertOptions) {
    public static ConcertOptionListResponse from(List<ConcertOption> concertOptions) {
        return new ConcertOptionListResponse(concertOptions.stream().map(ConcertOptionResponse::from).toList());
    }
}
