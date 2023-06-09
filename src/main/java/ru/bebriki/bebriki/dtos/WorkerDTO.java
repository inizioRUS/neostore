package ru.bebriki.bebriki.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
