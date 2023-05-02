/*
    Kyle Scannell
    CPSC 1060: Programming Assignment 2
    4/27/23
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> roster = new ArrayList<String>();
        HashMap<Integer, String> pitchTypes = new HashMap<Integer, String>();

        pitchTypes.put(1, "Fastball");
        pitchTypes.put(2, "Curveball");
        pitchTypes.put(3, "Slider");
        pitchTypes.put(4, "Ball");

        String playerName;

        AtBat atBat; 
        Bases bases;
        Pitch pitch = new Pitch();

        System.out.println("Hi welcome to the ABL (Adkins Baseball Leage)");
        System.out.println("Please input your team name:");
        String teamName = scnr.nextLine();
        System.out.println(teamName + " will need to have 3 players, please enter the names below.");
        for (int i = 0; i < 3; i++) {   
            System.out.println("Please input a name for player " + i);
            playerName = scnr.nextLine();
            roster.add(playerName); 
        }

        System.out.println();
        System.out.println(roster.get(0) + " is your contact hitter, they will most likely get a base hit, but not as many home runs!");
        System.out.println(roster.get(1) + " is your power hitter, they wont hit the ball as much, but when they do, it has a higher chance of being a home run!");
        System.out.println(roster.get(2) + " is your best hitter, they hit for high average and power!");
        System.out.println();

        boolean isOut = false;
        boolean isHit = false; 
        boolean isWalk = false;
        int guess;
        int inningCount = 1;
        String[][] fieldOfPlay = new String[3][7];
        int playerScore = 0;
        int robotScore = 0;
        String pitchResult = "";
        boolean isStrike;
        boolean somethingHappened;
        String resultOfPlay = "";
        int outs;

        while (inningCount <= 3) {
            outs = 0;
            bases = new Bases();
            while (outs < 3) {
                for (int i = 0; i < 3; i++) {
                    atBat = new AtBat();
                    atBat.getCount();
                    bases.getFieldOfPlay(teamName, playerScore, robotScore, outs, inningCount);
                    
                    isOut = false;
                    isHit = false;
                    isWalk = false;
                    somethingHappened = false;

                    while (somethingHappened == false) {
                        playerName = roster.get(i);
                        isStrike = false;
                        System.out.println(roster.get(i) + " guess what pitch is coming: (1, fastball) (2, curveball) (3, slider) (4, ball)");
                        guess = scnr.nextInt();
                        System.out.println();
                        pitchResult = pitch.hereComesThePitch(guess, roster.get(i));

                        if (pitchResult.equals("ball")) {
                            atBat.setCount(isStrike);
                            atBat.getCount();
                            isWalk = atBat.isBB(playerName);
                            if (isWalk == true) {
                                playerScore += bases.playerWalked();
                                somethingHappened = true;
                            }
                        }
                        else if (pitchResult.equals("strike")) {
                            isStrike = true;
                            atBat.setCount(isStrike);
                            atBat.getCount();
                            isOut = atBat.isK(playerName);
                        }
                        if (pitchResult.equals("inPlay")) {
                            resultOfPlay = bases.resultOfPlay(playerName, i);
                            if (resultOfPlay.equals("single")) {
                                playerScore += bases.hitSingle();
                                isHit = true;
                            }
                            if (resultOfPlay.equals("double")) {
                                playerScore += bases.hitDouble();
                                isHit = true;
                            }
                            if (resultOfPlay.equals("triple")) {
                                playerScore += bases.hitTriple();
                                isHit = true;
                            }
                            if (resultOfPlay.equals("homeRun")) {
                                playerScore += bases.hitHomeRun(playerName);
                                isHit = true;
                            }
                            if (resultOfPlay.equals("out")) {
                                isOut = true;
                            }
                            
                            
                        }
                        if (isHit == true || isOut == true) {
                            if (isOut == true) {
                                outs += 1;
                            }
                            somethingHappened = true;
                        }
                    }
                    if (outs == 3) {
                        break;
                    }
                } 
                
            }
            inningCount += 1;
            robotScore += bases.botRunsScored(teamName, inningCount); 
        }

        System.out.println("THATS THE BALLGAME!");
        GameOver gameOver = new GameOver(playerScore, robotScore, teamName);


    }
}