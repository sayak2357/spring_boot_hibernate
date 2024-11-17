package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    // Define constructor for dependency injection

//    @Autowired
//    public DemoController(Coach theCoach){
//        this.myCoach = theCoach;
//    }

    @Autowired
    public void setCoach(@Qualifier("swimCoach") Coach theCoach){
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWOrkout(){
        return myCoach.getDailyWorkout();
    }
}
