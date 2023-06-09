package ru.bebriki.bebriki.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryItemResponse {
    private String category;
    private long count;
}