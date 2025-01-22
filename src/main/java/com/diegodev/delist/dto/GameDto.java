package com.diegodev.delist.dto;

import jakarta.persistence.Column;

public record GameDto(
        Long id,
        String title,
        Integer year,
        String genre,
        String platforms,
        Double score,
        String imgUrl,
        String shortDescription,
        String longDescription) {
}
