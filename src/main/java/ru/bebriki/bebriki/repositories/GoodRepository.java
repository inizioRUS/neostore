package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bebriki.bebriki.models.Good;

public interface GoodRepository extends JpaRepository<Good, Integer> {
<<<<<<< HEAD

    Good findByName(String name);

=======
    interface GoodRepository extends JpaRepository<Good, Integer> {
        Good findByName(String name);
    }
>>>>>>> 722d87c380da5631d90541559a98c28a23d31e9b
}
