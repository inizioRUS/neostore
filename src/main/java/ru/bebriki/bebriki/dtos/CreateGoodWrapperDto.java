package ru.bebriki.bebriki.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
public class CreateGoodWrapperDto {
    private String title;
    private String category;
    private Integer price;
    private Integer discount;
    private String description;
    private String imageURL;
    private Integer amount;
}