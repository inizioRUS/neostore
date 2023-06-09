package ru.bebriki.bebriki.models;


import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "total")
    private Integer total;
    @Column(name = "goodId")
    private Integer goodId;

    public OrderItem(Integer amount, Integer total, Integer goodId) {
        this.amount = amount;
        this.total = total;
        this.goodId = goodId;
    }
}
