package com.guessingnumber.gessingnumber.service;

import org.springframework.stereotype.Service;

import java.util.Random;
//@Service


public class GameService {


    private int attempt=5;
    private int score=0;
    private int computerscore=0;

    public int getComputerscore() {
        return computerscore;
    }



    public int getScore() {
        return score;
    }

    public String play(int num){
        int computerGeneratedNumber = new Random().nextInt(100);
        if(attempt>0){
//            int computerGeneratedNumber = new Random().nextInt(100);
            System.out.println(computerGeneratedNumber);
            attempt--;
            if(computerGeneratedNumber>num){
                computerscore++;
                return "Your value is lessar";
            }
            else if(computerGeneratedNumber==num){
                score++;
                return "You got it ";
            }
            else{
                computerscore++;
               return "Your value is higher";
            }
        }else{
            return "Maximum limit Reaches";
        }
    }

    public void reset(){
        attempt=5;
        score=0;
        computerscore=0;    }
}
