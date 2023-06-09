package ru.bebriki.bebriki.dtos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bebriki.bebriki.models.Good;
import ru.bebriki.bebriki.models.Order;
import ru.bebriki.bebriki.models.Task;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO {

    private Integer id;
    private String name;
    private String surname;
    private String secondName;
    private String login;
    private String post;
    private String position;
    private Integer age;
    private String phone;
    private Integer balance;
    private String password;
    private String role;
    private String gender;
    private List<Order> orders;
    private String imageURL;


}
