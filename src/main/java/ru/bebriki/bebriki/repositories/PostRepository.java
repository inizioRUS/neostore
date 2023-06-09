package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByName(String name);
}
