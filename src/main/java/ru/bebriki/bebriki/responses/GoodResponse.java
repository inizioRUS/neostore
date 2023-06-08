package ru.bebriki.bebriki.responses;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bebriki.bebriki.models.Good;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodResponse {

    private Integer id;
    private String title;
    private Integer categoryId;
    private Integer price;
    private Integer discount;
    private String description;
    private String imageURL;
    private Integer amount;

    public static GoodResponse cast(Good good){
        return GoodResponse.builder()
                .id(good.getId())
                .title(good.getTitle())
                .categoryId(good.getCategoryId())
                .price(good.getPrice())
                .discount(good.getDiscount())
                .description(good.getDescription())
                .imageURL(good.getImageURL())
                .amount(good.getAmount())
                .build();
    }
}