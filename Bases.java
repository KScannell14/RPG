import java.util.Random;

public class Bases {
    public String [][] fieldOfPlay = new String [3][7];
    public Random randGen = new Random();

    int rows = 3;
    int columns = 7;
    int single;
    int twoBagger;
    int triple;
    int homeRun;
    int flyout;
    int groundout;
    boolean runnerOnFirst = false;
    boolean runnerOnSecond = false;
    boolean runnerOnThird = false;
    int runsScored;
    int playerRunsThisInning = 0;

    
    public Bases() {
        fieldOfPlay[0][0] = " ";
        fieldOfPlay[0][1] = " ";
        fieldOfPlay[0][2] = " ";
        fieldOfPlay[0][3] = "X";
        fieldOfPlay[0][4] = " ";
        fieldOfPlay[0][5] = " ";
        fieldOfPlay[0][6] = " ";
        fieldOfPlay[1][0] = "X";
        fieldOfPlay[1][1] = " ";
        fieldOfPlay[1][2] = " ";
        fieldOfPlay[1][3] = " ";
        fieldOfPlay[1][4] = " ";
        fieldOfPlay[1][5] = " ";
        fieldOfPlay[1][6] = "X";
        fieldOfPlay[2][0] = " ";
        fieldOfPlay[2][1] = " ";
        fieldOfPlay[2][2] = " ";
        fieldOfPlay[2][3] = "X";
        fieldOfPlay[2][4] = " ";
        fieldOfPlay[2][5] = " ";
        fieldOfPlay[2][6] = " ";
    }

    public void getFieldOfPlay (String teamName, int playerScore, int robotScore, int outs, int inningCount) {
        System.out.println("Inning: " + inningCount);
        System.out.println("There are " + outs + " out(s)");
        System.out.println(teamName + ": " + playerScore);
        System.out.println("The Adkins Eradicators: " + robotScore);

        for (int j = 0; j < rows; j++) {
            for (int k = 0; k < columns; k++) {
                System.out.print(fieldOfPlay[j][k]);
            }
            System.out.println();
        }
    }

    public String resultOfPlay(String playerName, int playerType) {
        int randomNum = randGen.nextInt(100);
        String result;
        switch (playerType) {
            case 0:
                single = 30;
                twoBagger = 60;
                triple = 70;
                homeRun = 80;
                flyout = 90;
                groundout = 100;
            break;

            case 1: 
                single = 10;
                twoBagger = 20;
                triple = 30;
                homeRun = 70;
                flyout = 85;
                groundout = 100;
            break;

            case 2:
                single = 20;
                twoBagger = 40;
                triple = 60;
                homeRun = 80;
                flyout = 90;
                groundout = 100;
            break;
        }

        if (randomNum <= single) {
            System.out.println(playerName + " has hit a single!");
            result = "single";
            return result;
        }
        else if (randomNum > single && randomNum <= twoBagger) {
            System.out.println(playerName + " has hit a double!");
            result = "double";
            return result;
        }
        else if (randomNum > twoBagger && randomNum <= triple) {
            System.out.println(playerName + " has hit a triple");
            result = "triple";
            return result;
        }
        else if (randomNum > triple && randomNum <= homeRun) {
            result = "homeRun";
            return result;
        }
        else if (randomNum > homeRun && randomNum < flyout) {
            System.out.println(playerName + " has flown out");
            result = "out";
            return result;
        }
        else {
            System.out.println(playerName + " has grounded out");
            result = "out";
            return result;
        }

    }


    public int playerWalked() {
        runsScored = 0;
        if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if bases are loaded
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if runners on 1st and 2nd
            fieldOfPlay[1][0] = "O";
            //baseRunners.put(2, "on base");
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O")) {
            //if runner on first
            fieldOfPlay[0][3] = "O";
            //baseRunners.put(1, "on base");
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O") ) {
            //if runners on first and 3rd
            fieldOfPlay[0][3] = "O";
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runners on 2nd and 3rd
            fieldOfPlay[1][6] = "O";
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 2nd
            fieldOfPlay[1][6] = "O";
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 3rd
            fieldOfPlay[1][6] = "O";
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if no one is on
            fieldOfPlay[1][6] = "O";
        }
        
        return runsScored;
    }

    public int hitSingle() {
        runsScored = 0;
        if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if bases are loaded
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if runners on 1st and 2nd
            fieldOfPlay[1][0] = "O";
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O")) {
            //if runner on first
            fieldOfPlay[0][3] = "O";
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O") ) {
            //if runners on first and 3rd
            fieldOfPlay[0][3] = "O";
            fieldOfPlay[1][0] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runners on 2nd and 3rd
            fieldOfPlay[1][6] = "O";
            fieldOfPlay[0][3] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 2nd
            fieldOfPlay[1][6] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][0] = "O";
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 3rd
            fieldOfPlay[1][6] = "O";
            fieldOfPlay[1][0] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if no one is on
            fieldOfPlay[1][6] = "O";
        }
        
        return runsScored;
    }

    public int hitDouble() {
        runsScored = 0;
        if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if bases are loaded
            fieldOfPlay[1][6] = "X";
            runsScored = 2;
            playerRunsThisInning += 2;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if runners on 1st and 2nd
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[1][6] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O")) {
            //if runner on first
            fieldOfPlay[1][6] = "X";
            fieldOfPlay[0][3] = "O";
            fieldOfPlay[1][6] = "O";
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O") ) {
            //if runners on first and 3rd
            fieldOfPlay[1][6] = "X";
            fieldOfPlay[0][3] = "O";
            fieldOfPlay[1][0] = "O";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runners on 2nd and 3rd
            fieldOfPlay[1][0] = "X";
            runsScored = 2;
            playerRunsThisInning += 2;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 2nd
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 3rd
            fieldOfPlay[0][3] = "O";
            fieldOfPlay[1][0] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if no one is on
            fieldOfPlay[0][3] = "O";
        }
        
        return runsScored;
    }

    public int hitTriple() {
        runsScored = 0;
        if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if bases are loaded
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 3;
            playerRunsThisInning += 3;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if runners on 1st and 2nd
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 2;
            playerRunsThisInning += 2;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O")) {
            //if runner on first
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O") ) {
            //if runners on first and 3rd
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runners on 2nd and 3rd
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 2;
            playerRunsThisInning += 2;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 2nd
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 3rd
            fieldOfPlay[1][0] = "O";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if no one is on
            fieldOfPlay[1][0] = "O";
        }
        
        return runsScored;
    }
    public int hitHomeRun(String playerName) {
        runsScored = 0;
        if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if bases are loaded
            System.out.println(playerName + " hit a GRAND SLAM HOME RUN!!!!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 4;
            playerRunsThisInning += 4;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("O")) {
            //if runners on 1st and 2nd
            System.out.println(playerName + " hit a 3-RUN HOME RUN!!!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 3;
            playerRunsThisInning += 3;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O")) {
            //if runner on first
            System.out.println(playerName + " hit a 2-RUN HOME RUN!!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 2;
            playerRunsThisInning += 2;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("O") ) {
            //if runners on first and 3rd
            System.out.println(playerName + " hit a 3-RUN HOME RUN!!!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 3;
            playerRunsThisInning += 3;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runners on 2nd and 3rd
            System.out.println(playerName + " hit a 3-RUN HOME RUN!!!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 3;
            playerRunsThisInning += 3;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("O") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 2nd
            System.out.println(playerName + " hit a 2-RUN HOME RUN!!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 2;
            playerRunsThisInning += 2;
        }
        else if (fieldOfPlay[1][0].equals("O") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if runner on 3rd
            System.out.println(playerName + " hit a 2-RUN HOME RUN!!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 2;
            playerRunsThisInning += 2;
        }
        else if (fieldOfPlay[1][0].equals("X") && fieldOfPlay[0][3].equals("X") && fieldOfPlay[1][6].equals("X")) {
            //if no one is on
            System.out.println(playerName + " hit a SOLO HOME RUN!");
            fieldOfPlay[1][0] = "X";
            fieldOfPlay[0][3] = "X";
            fieldOfPlay[1][6] = "X";
            runsScored = 1;
            playerRunsThisInning += 1;
        }
        
        return runsScored;
    }

    public int botRunsScored(String playerName, int inningCount) {
        int botRuns;
        if (inningCount == 1) {
            botRuns = randGen.nextInt(playerRunsThisInning + 2);
        }
        else if (inningCount == 2) {
            botRuns = randGen.nextInt(playerRunsThisInning + 1);
        }
        else {
            botRuns = randGen.nextInt(playerRunsThisInning + 1);
        }

        System.out.println();
        System.out.println(playerName + " scored " + playerRunsThisInning + " this inning.");
        System.out.println("The Adkins Eradicators scored " + botRuns + " this inning.");
        System.out.println();
        return botRuns;
    }


}

/*
   x 
x     x
   x

0123
0123456

1st base = 1,6
2nd base = 0,3
3rd base = 1,0
Home = 2,3
*/