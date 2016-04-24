package ch07.Jaeyun;

public class DeckTest {

	class Deck {
		final int CARD_NUM = 52;
		Card c[] = new Card[CARD_NUM];
		
		public Deck() {
			int i = 0;
			for (int j = Card.KIND_MAX; j > 0; j--) {
				for (int k = 1; k < Card.NUM_MAX + 1; k++) {
					c[i++] = new Card(j, k);
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		Card c = d.pick();
		System.out.println(c);
		d.shuffle();
		c - d.pick(0);
		System.out.println(c);
	}

}
