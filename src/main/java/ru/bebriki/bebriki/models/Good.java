package ru.bebriki.bebriki.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private Integer price;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "description")
    private String description;
    @Column(name = "imageURL")
    private String imageURL;
    @Column(name = "amount")
    private Integer amount;
//    @ManyToMany(mappedBy = "goods", fetch = FetchType.LAZY)
//    List<Worker> workers;
}
