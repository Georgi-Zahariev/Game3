class ThreeGroup {
	private int a, b, c;

	public ThreeGroup(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public void doMove(int kind, int cnt) {
		switch (kind) {
		case 1:
			a -= cnt;
			break;
		case 2:
			b -= cnt;
			break;
		case 3:
			c -= cnt;
			break;
		}
	}

	public void undoMove(int kind, int cnt) { // Vyzstanovqvqme sled hoda
		doMove(kind, -cnt);
	}

	public int play(int player) {
		int q;
		if (a == 0 && b == 0 && c == 0)
			return (player ^ 0b11); // player^3
		if (a == 0 && b == 0 && c != 0)
			return player;
		if (a == 0 && b != 0 && c == 0)
			return player;
		if (a != 0 && b == 0 && c == 0)
			return player;

		for (int i = 1; i <= a; i++) {
			doMove(1, i);
			q = play(player ^ 3);
			undoMove(1, i);
			if (q == player)
				return player;
		}

		for (int i = 1; i <= b; i++) {
			doMove(2, i);
			q = play(player ^ 3);
			undoMove(2, i);
			if (q == player)
				return player;
		}
		for (int i = 1; i <= b; i++) {
			doMove(2, i);
			q = play(player ^ 3);
			undoMove(2, i);
			if (q == player)
				return player;
		}
		for (int i = 1; i <= c; i++) {
			doMove(3, i);
			q = play(player ^ 3);
			undoMove(3, i);
			if (q == player)
				return player;
		}
		return (player ^ 3);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; i++)
			for (int j = i + 1; j <= 10; j++)
				for (int k = j + 1; k <= 10; k++) {
					ThreeGroup g = new ThreeGroup(i, j, k);
					if (g.play(1) == 2)
						System.out.println("(" + i + ", " + j + ", " + k + ")");

				}
		System.out.println("Done");
	}

}
