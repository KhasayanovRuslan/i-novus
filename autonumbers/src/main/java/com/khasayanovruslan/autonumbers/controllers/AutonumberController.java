package com.khasayanovruslan.autonumbers.controllers;

import com.khasayanovruslan.autonumbers.services.AutonumberGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class AutonumberController {

    @Autowired
    AutonumberGenerationService autonumberGenerationService;

    @GetMapping("/random")
    public String random() {
        return autonumberGenerationService.addRandom();
    }

    @GetMapping("/next")
    public String next() {
        return autonumberGenerationService.addNext();
    }

}
