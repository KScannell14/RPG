default: Main.java AtBat.java Bases.java Pitch.java GameOver.java 
	javac Main.java AtBat.java Bases.java Pitch.java GameOver.java

run: Main.java AtBat.java Bases.java Pitch.java GameOver.java
	java Main AtBat Bases Pitch GameOver

clean:
	rm -f *.class
