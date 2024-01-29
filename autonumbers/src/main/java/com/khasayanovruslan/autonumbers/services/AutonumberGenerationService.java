package com.khasayanovruslan.autonumbers.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AutonumberGenerationService {

    private final Random randomizer = new Random();
    private StringBuilder autonumber = new StringBuilder();
    private final char[] autonumberLetters = new char[]{'А', 'Е', 'Т', 'О', 'Р', 'Н', 'У', 'К', 'Х', 'С', 'В', 'М'};

    private final int LENGTH_AUTONUMBER_LETTERS = autonumberLetters.length - 1;
    private final int MAX_AUTONUMBER = 999;
    private final String REGION = "116RUS";
    private final String FIRST_POSITION_DIGITS = "0";
    private final String FIRST_AND_SECOND_POSITION_DIGITS = "00";

    private int firstLetterPosition;
    private int secondLetterPosition;
    private int thirdLetterPosition;
    private int digits;

    public String addRandom() {
        boolean flag = true;

        while(flag) {
            autonumber.setLength(0);
            autonumber.append(autonumberLetters[randomizer.nextInt(LENGTH_AUTONUMBER_LETTERS)]);
            int randomAutonumber = randomizer.nextInt(MAX_AUTONUMBER);

            if(randomAutonumber < 10) {
                autonumber.append(FIRST_AND_SECOND_POSITION_DIGITS);
            }
            else if(randomAutonumber < 100) {
                autonumber.append(FIRST_POSITION_DIGITS);
            }

            autonumber.append(randomAutonumber);
            autonumber.append(autonumberLetters[randomizer.nextInt(LENGTH_AUTONUMBER_LETTERS)]);
            autonumber.append(autonumberLetters[randomizer.nextInt(LENGTH_AUTONUMBER_LETTERS)]);
            autonumber.append(REGION);

            if(!File.findAutonumber(autonumber.toString())) {
                File.appendAutonumber("autonumbers.txt", autonumber);
                flag = false;
            }
        }

        return autonumber.toString();
    }

    public String addNext() {
        boolean flag = true;

        while(flag) {
            autonumber.setLength(0);

            if(digits > 999) {
                digits = 0;
                thirdLetterPosition++;

                if(thirdLetterPosition > LENGTH_AUTONUMBER_LETTERS) {
                    thirdLetterPosition = 0;
                    secondLetterPosition++;
                }

                if(secondLetterPosition > LENGTH_AUTONUMBER_LETTERS) {
                    secondLetterPosition = 0;
                    firstLetterPosition++;
                }

                if(firstLetterPosition > LENGTH_AUTONUMBER_LETTERS) {
                    throw new RuntimeException("Номера закончились!");
                }
            }

            autonumber.append(autonumberLetters[firstLetterPosition]);
            if(digits < 10) {
                autonumber.append(FIRST_AND_SECOND_POSITION_DIGITS);
            }
            else if(digits < 100) {
                autonumber.append(FIRST_POSITION_DIGITS);
            }
            autonumber.append(digits++);
            autonumber.append(autonumberLetters[secondLetterPosition]);
            autonumber.append(autonumberLetters[thirdLetterPosition]);
            autonumber.append(REGION);

            if(!File.findAutonumber(autonumber.toString())){
                File.appendAutonumber("autonumbers.txt", autonumber);
                flag = false;
            }

        }
        return autonumber.toString();
    }
}
