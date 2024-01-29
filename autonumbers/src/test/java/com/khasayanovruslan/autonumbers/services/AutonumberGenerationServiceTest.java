package com.khasayanovruslan.autonumbers.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutonumberGenerationServiceTest {

    @Autowired
    private AutonumberGenerationService autonumberGenerationService;

    @Test
    void addRandom() {
        String randomAutonumber = autonumberGenerationService.addRandom();
        Assert.assertNotNull(randomAutonumber);
    }

    @Test
    void addNext() {
        String nextAutonumber = autonumberGenerationService.addNext();
        Assert.assertNotNull(nextAutonumber);
    }

    @Test
    void findAutonumber() {
        String nextAutonumber = autonumberGenerationService.addNext();
        Assert.assertTrue(File.findAutonumber(nextAutonumber));
    }
}
