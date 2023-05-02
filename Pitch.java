import java.util.Random;
import java.util.HashMap;

public class Pitch {
    public HashMap<Integer, String> pitchTypes = new HashMap<Integer, String>();
    public Random randGen = new Random();

    public Pitch() {
        pitchTypes.put(0, "Fastball");
        pitchTypes.put(1, "Curveball");
        pitchTypes.put(2, "Slider");
        pitchTypes.put(3, "Ball");
    }
    

    public String hereComesThePitch(int guess, String playerName) {
        guess -= 1;
        String result; 
        System.out.println("Here comes the pitch!");
        int randomInt = randGen.nextInt(4);
        System.out.println(pitchTypes.get(randomInt) + "!");
        System.out.println(playerName + " guessed: " + pitchTypes.get(guess));
        
        if (randomInt == guess) {
            if (guess == 3) {
                result = "ball";
            }
            else {
                result = "inPlay";
            }
        }
        else {
            result = "strike";
        }

        return result;
    }
}