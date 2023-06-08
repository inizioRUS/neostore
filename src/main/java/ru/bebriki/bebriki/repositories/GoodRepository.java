package ru.bebriki.bebriki.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Integer> {
    interface GoodRepository extends JpaRepository<Good, Integer> {
        Good findByName(String name);
    }
}
