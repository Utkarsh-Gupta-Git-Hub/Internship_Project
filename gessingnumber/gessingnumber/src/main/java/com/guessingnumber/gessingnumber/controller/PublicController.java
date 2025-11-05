package com.guessingnumber.gessingnumber.controller;

import com.guessingnumber.gessingnumber.service.GameService;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;


@Controller
public class PublicController {



 private GameService service;




    public PublicController() {
        this.service = new GameService();
    }

    @GetMapping(path = {"","/","/home"})
    public String home(){
        return "home";
    }

    @PostMapping("/do")
    public String perform(@RequestParam int numbers,Model m){
        m.addAttribute("message",service.play(numbers));
        m.addAttribute("userScore",service.getScore());
        m.addAttribute("computerScore",service.getComputerscore());
        return "home";
    }


    @PostMapping("reset")
    public String reset(){
        service.reset();
        return "redirect:/home";
    }


}
