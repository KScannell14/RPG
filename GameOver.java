public class GameOver {
    public GameOver(int playerScore, int botScore, String teamName) {
        if (playerScore > botScore) {
            System.out.println(teamName + " defeat The Adkins Eradicators by a score of " + playerScore + " to " + botScore + "!");
        }
        else if (botScore > playerScore) {
            System.out.println("The Adkins Eradicators defeat " + teamName + " by a score of " + botScore + " to " + playerScore + " :(");
        }
        else {
            System.out.println(teamName + " tie with The Adkins Eradicators " + playerScore + " " + botScore + "...");
        }
    }
}