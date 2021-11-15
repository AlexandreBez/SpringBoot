package com.myapp.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
    
    @GetMapping("/")
    public String sayHello(){
        return "HOY MATE!!!! What time is now????? " + LocalDateTime.now();
    }

    @GetMapping("/code")
    public String getCode(){
        return "Bloody HElll! You finally working don't ya";
    }
}