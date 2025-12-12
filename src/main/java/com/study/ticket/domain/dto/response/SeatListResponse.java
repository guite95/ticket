package com.study.ticket.domain.dto.response;

import com.study.ticket.domain.Entity.Seat;

import java.util.List;

public record SeatListResponse(List<SeatResponse> seats) {
    public static SeatListResponse from(List<Seat> seats) {
        return new SeatListResponse(seats.stream().map(SeatResponse::from).toList());
    }
}
