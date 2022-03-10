package com.example.LogN.user;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.*;

import java.util.*;


@Configuration
public class HumanConfig {
    @Bean
    CommandLineRunner commandLineRunner(HumanRepository repository) {
        return args -> {
            Human Luminexium = new Human(
                    1L,
                    "Luminexium",
                    "Luminexium460@gmail.com",
                    "*****",
                    true
            );
            Human Frank = new Human(
                    2L,
                    "Frank",
                    "Frank@frank.Frank",
                    "FrankistheFrankestfrank",
                    false
            );

            Human Billy = new Human(
                    3L,
                    "Ethan Goldwyn",
                    "pimpin@demhoes.org",
                    "ISeduceTheDragon",
                    false
            );
            repository.saveAll(
                    List.of(Luminexium, Frank, Billy)
            );

        };
    }
}
