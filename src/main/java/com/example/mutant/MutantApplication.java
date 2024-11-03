package com.example.mutant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutantApplication {

    public static void main(String[] args) {
        SpringApplication.run(MutantApplication.class, args);

        MutantDetector detector = new MutantDetector();
        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean isMutant = detector.isMutant(dna);
        System.out.println("Is mutant: " + isMutant);
    }
}
