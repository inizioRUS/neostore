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
    @Column(name = "gender")
    private String gender;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "wishes", joinColumns = {
            @JoinColumn(name = "worker_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "good_id", referencedColumnName = "id")
    })
    List<Good> goods;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Task> tasks = new ArrayList<>();
}
