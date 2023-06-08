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
}
