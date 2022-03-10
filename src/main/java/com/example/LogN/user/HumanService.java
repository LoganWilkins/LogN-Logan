package com.example.LogN.user;
//package com.example.LogN.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.lang.*;
@Service
public class HumanService {
    static HumanRepository humanRepository;
    @Autowired
    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    public static List<Human> findHumans() {
        return humanRepository.findAll();
    }


    public static void addNewHuman(Human human) {
        Optional<Human> humanOptional =  humanRepository.findHumanByEmail(human.getEmail());
        if(humanOptional.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        humanRepository.save(human);
        System.out.println(human);
    }

    public static Optional<Human> findHumanByName(String name) {
        return humanRepository.findHumanByName(name);
    }

    public void deleteHuman(Long humanId) {

            boolean exists = humanRepository.existsById(humanId);
            if (!exists){
                throw new IllegalStateException("unfound");
            }
            humanRepository.deleteById(humanId);

    }
    @Transactional
    public void updateHuman(Long humanId, String username, String email) {
        Human human = humanRepository.findById(humanId)
                .orElseThrow(() -> new IllegalStateException("empty"));
        if (username != null &&
                username.length() > 0
                && !Objects.equals(human.getUsername(),username)) {
            human.setUsername(username);
            System.out.println(username);
        }

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(human.getEmail(), email)) {
            Optional<Human> humanOptional = humanRepository
                    .findHumanByEmail(email);
            if (humanOptional.isPresent()) {
                throw new IllegalStateException("email take");
            }
            human.setEmail(email);
            humanRepository.save(human);
        }
    }
}
