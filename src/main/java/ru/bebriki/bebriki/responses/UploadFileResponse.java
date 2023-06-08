package ru.bebriki.bebriki.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileResponse {
    private String url;
    private String title;
}