public class AtBat {

    public int [] count = new int[3];
    private int strikes;
    private int balls;
    public boolean strikeOut = false;
    public boolean walk = false;

    public AtBat() {
        balls = 0;
        strikes = 0;
        count[0] = balls;
        count[1] = strikes;
    }

    public void setCount(boolean isStrike) {
        if (isStrike == true) {
            strikes += 1;
            count[1] = strikes;
        }
        else {
            balls += 1; 
            count[0] = balls;
        }
    }

    public boolean isK(String playerName) {
        strikeOut = false;

        if (strikes == 3) {
            strikeOut = true;
            System.out.println(playerName + " has struck out.");
        }

        return strikeOut;
    }

    public boolean isBB(String playerName) {
        walk = false;

        if (balls == 4) {
            walk = true;
            System.out.println(playerName + " has walked.");
        }

        return walk;
    }

    public void getCount() {
        System.out.print("The count is: ");
        System.out.println(count[0] + "-" + count[1]);
    }
}