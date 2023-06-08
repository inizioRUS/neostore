package ru.bebriki.bebriki.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "categoryId")
    private Integer categoryId;
    @Column(name = "price")
    private Integer price;
    @Column(name = "name")
    @Column(name = "name")
    @Column(name = "name")
    @Column(name = "name")
}
