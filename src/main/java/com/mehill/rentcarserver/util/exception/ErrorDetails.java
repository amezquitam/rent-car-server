package com.mehill.rentcarserver.util.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorDetails (
    LocalDateTime threwAt,
    String description,
    String path,
    String errorCode
) {}
