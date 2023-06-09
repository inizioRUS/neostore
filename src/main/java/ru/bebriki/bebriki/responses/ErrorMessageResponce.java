package ru.bebriki.bebriki.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageResponce {
    private String message;
}