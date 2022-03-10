package com.example.LogN.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
        Optional<Human> findHumanByEmail(String email);

        @Query ("SELECT GUY FROM Human GUY WHERE GUY.username = ?1")
        Optional <Human> findHumanByName(String name);

}

