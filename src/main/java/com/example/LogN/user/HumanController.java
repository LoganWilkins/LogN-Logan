package com.example.LogN.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.LogN.user.HumanService.humanRepository;


@RestController
@RequestMapping(path = "api/v1/logn")
public class HumanController {

    private final HumanService humanService;

    @Autowired
    public HumanController(HumanService humanService) {
        this.humanService = new HumanService(humanRepository);
    }


    @GetMapping
    public List<Human> findHumans() {
        return HumanService.findHumans();
    }

    @GetMapping(path="{name}")
    public Optional<Human> findHumanByName(@PathVariable String name) {
        return HumanService.findHumanByName(name);
    }

    @PostMapping
    public void registerNewHuman(@RequestBody Human human) {
        HumanService.addNewHuman(human);

    }

    @DeleteMapping(path = "{humanId}")
    public void deleteHuman(@PathVariable("humanId") Long humanId) {
        humanService.deleteHuman(humanId);
    }

    @PutMapping(path = "{humanId}")
    public void updateHuman(
            @PathVariable("humanId") Long humanId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String email
            )
    {
        humanService.updateHuman(humanId,username,email );
    }
}
