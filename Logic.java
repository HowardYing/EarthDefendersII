import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Logic {
	static int score = 0;
	static int fieldLength = 50;
	static int playerPos = 5;
	static String[][] field = new String[fieldLength][11];
	static ArrayList<String> player = new ArrayList<String>();

	public static void setup() {
		for (int i = 0; i <= (field.length) - 1; i++) {
			field[i][0] = "|";
			field[i][10] = "|";
			int star = ThreadLocalRandom.current().nextInt(1, 10);
			for (int l = 1; l <= (field[0].length) - 2; l++) {
				field[i][l] = " ";
				field[i][star] = "*";
			}
		}
		player.add(0, "|");
		player.add(1, " ");
		player.add(2, " ");
		player.add(3, " ");
		player.add(4, " ");
		player.add(5, "V");
		player.add(6, " ");
		player.add(7, " ");
		player.add(8, " ");
		player.add(9, " ");
		player.add(10, "|");

	}

	public static void printField() {
		System.out.println();
		for (int j = 0; j <= field.length - 1; j++) {
			for (int k = 0; k <= field[j].length - 1; k++) {
				System.out.print(field[j][k]);
			}
			System.out.println();
		}
		for (int m = 0; m <= player.size() - 1; m++) {
			System.out.print(player.get(m).toString());
		}
		System.out.println();
		System.out.println("|---------|");
		System.out.println();
	}

	public static void moveDown() {
		String[][] temp = new String[field.length - 1][field[0].length];
		for (int i = 0; i < field.length - 1; i++) {
			for (int j = 0; j < field[0].length; j++) {
				temp[i][j] = field[i][j];
			}

		}
		field = temp;
	}

	public static void playerL() {
		player.set(playerPos, " ");
		playerPos--;
		player.set(playerPos, "V");
	}

	public static void playerR() {
		player.set(playerPos, " ");
		playerPos++;
		player.set(playerPos, "V");
	}
	public static void check() {
		if (field[field.length-1][playerPos].equals("*")) {
			score++;
		}
	}
}
