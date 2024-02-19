package com.bazaratech.starter.controller;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class MessageResponse {
    private UUID uuid;
    private String message;
}
