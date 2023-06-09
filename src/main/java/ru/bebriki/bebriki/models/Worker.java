package ru.bebriki.bebriki.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @Column(name = "login")
    private String login;
    @Column(name = "postId")
    private Integer postId;
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
    @Column(name = "gender")
    private String gender;
    @Column(name = "imageURL")
    private String imageURL;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "worker")
    List<Order> orders;

    @Column(name = "taskId")
    private Integer taskId;

}
