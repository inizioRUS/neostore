package ru.bebriki.bebriki.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateGoodDto {
    private int price;
    private int amount;
    private String imageURL;
    private String title;
}