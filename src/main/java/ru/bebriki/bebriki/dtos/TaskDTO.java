package ru.bebriki.bebriki.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bebriki.bebriki.models.Post;
import ru.bebriki.bebriki.models.Worker;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Integer id;

    private String name;

    private String description;

    private Integer difficulty;

    private Boolean isDone;

    private String postName;

}
