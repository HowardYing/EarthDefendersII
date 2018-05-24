import java.util.Scanner;

public class EarthDefendersII {
	public static void main(String[] args) {
		boolean start = false;
		String input = "";
		String startSeq = "";
		Scanner in = new Scanner(System.in);
		Logic.setup();
		System.out.println("*EARTH DEFENDERS II*");
		System.out.println("COMMANDER! Aliens have launched a barrage of missiles");
		System.out.println("at our planet! You must deflect them with your V ship!");
		System.out.println("A to move left, S to stay, D to move right!");
		System.out.println("Earth depends on it! Ready? Press S twice!");
		startSeq = in.next();
		if (startSeq.equals("S") || in.next().equals("s")) {
			start = true;
		}
		while (Logic.field.length > 0 && start == true) {
			Logic.check();
			Logic.printField();
			System.out.println("Score: " + Logic.score);
			System.out.print("Your move! Enter [A] or [D] or [S]: ");
			input = in.next();
			if (input.equals("a") || input.equals("A")) {
				Logic.playerL();
				Logic.moveDown();
			} else if (input.equals("d") || input.equals("D")) {
				Logic.playerR();
				Logic.moveDown();
			} else if (input.equals("s") || input.equals("S")) {
				Logic.moveDown();
			} else {
				System.out.println("What?");

			}
		}
		Logic.printField();
		System.out.println("COMMANDER, the alien barrage has stopped!");
		System.out.println("You have stopped " + Logic.score + "missiles!");
		if (Logic.score > 40) {
			System.out.println("Earth has suffered almost no damage, thanks to you!");
		} else if (Logic.score > 20) {
			System.out.println("Earth will recover swiftly, thanks to you!");
		} else if (Logic.score > 10) {
			System.out.println("Earth will need a while to recover...");
		}
		else {
			System.out.println("The planet is doomed! What the heck man!");
		}
	}
}