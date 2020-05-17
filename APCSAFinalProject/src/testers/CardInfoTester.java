package testers;

import java.util.ArrayList;
import cards.*;

public class CardInfoTester {

	public static void main(String[] args) {
		// Card Tests = Complete
		// CardStack Tests = Complete
		
		Card cardA = new Card();
		cardA.setSuit(3);
		cardA.setNumber(13);
		System.out.println("getSuit A: " + cardA.getSuit()); // 3
		System.out.println("getNum A: " + cardA.getNum()); // 13
		
		cardA.setFace(true);
		System.out.println("getFace A: " + cardA.getFace()); // true
		
		Card cardB = new Card(2, 10);
		cardB.setFace(true);
		System.out.println("getSuit B: " + cardB.getSuit()); // 2
		System.out.println("getNum B: " + cardB.getNum()); // 10

		
		CardStack stackA = new CardStack();
		System.out.println("Print stackA: " + stackA); // 0 false 0
		
		stackA.addCard(cardA);
		stackA.addCard(cardB);
		stackA.setPlayerOwner(4);
		stackA.setHasJokers(true);
		System.out.println("Print stackA 2: " + stackA); // 4 true 2
		System.out.println("dealRandom stackA: " + stackA.dealRandom()); // rand card
		System.out.println("getCards?: " + stackA.getCards());
		
		CardStack stackB = new CardStack(true);
		stackB.setPlayerOwner(3);
		stackB.fillStandard();
		System.out.println("Print stackB: " + stackB); // 3 true 54
		System.out.println(stackB.getCards());
		
		stackB.scramble();
		System.out.println(stackB.getCards());
		
	}

}
