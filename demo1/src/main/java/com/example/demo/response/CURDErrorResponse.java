package com.example.demo.response;

import java.time.LocalDateTime;

public record CURDErrorResponse(Long errorCode, String status, String message, String path, LocalDateTime timestamp) {
}
