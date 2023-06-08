package ru.bebriki.bebriki.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "vacancyId")
    private Integer vacancyId;
    @Column(name = "positionId")
    private Integer positionId;
    @Column(name = "age")
    private Integer age;
    @Column(name = "phone")
    private String phone;
    @Column(name = "balance")
    private Integer balance;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

}
