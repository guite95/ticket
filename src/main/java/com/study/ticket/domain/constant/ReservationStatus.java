package com.study.ticket.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ReservationStatus {
    PAID("PAID", "결제 완료"),
    NOT_PAID("NOT_PAID", "결제 전");

    private final String status;
    private final String description;
}
