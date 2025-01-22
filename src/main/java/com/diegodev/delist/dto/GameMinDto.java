package com.diegodev.delist.dto;

import jakarta.persistence.Column;

public record GameMinDto(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription) {
}
