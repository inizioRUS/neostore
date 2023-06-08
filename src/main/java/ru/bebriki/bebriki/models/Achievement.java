package ru.bebriki.bebriki.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "achievements")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "workerId")
    private Integer workerId;
    @Column(name = "achievementId")
    private String achievementId;
    @Column(name = "date")
    private LocalDateTime date;

}
