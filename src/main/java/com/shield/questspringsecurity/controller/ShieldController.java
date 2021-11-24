package com.shield.questspringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShieldController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to the SHIELD !!!";
    }

    @GetMapping("/avengers/assemble")
    public String hero() {
        return "Avengers ... Assemble !!!";
    }

    @GetMapping("/secret-bases")
    public String[] director() {
        String[] secret_bases = {"Regensburg", "Bielefeld", "gibtEsNicht", "trásElQuintoPino", "inTheMiddleOfNowhere", "amArschDerWelt" };
        return secret_bases;
    }
}