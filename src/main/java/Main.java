import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the Blackjack basic strategy calculator!");
        System.out.println("Enter all cards in your hand, separated by spaces, with capital letters for face cards.");
        System.out.print("Enter your hand: ");
        String hand = userInput.nextLine();
        System.out.print("Enter the dealer's up card: ");
        String dealerCardString = userInput.nextLine();
        String[] stringHand = hand.split(" ");
        ArrayList<Cards> cardHand = new ArrayList<>();
        for (String card : stringHand) {
            switch (card) {
                case "A" -> cardHand.add(Cards.ACE);
                case "2" -> cardHand.add(Cards.TWO);
                case "3" -> cardHand.add(Cards.THREE);
                case "4" -> cardHand.add(Cards.FOUR);
                case "5" -> cardHand.add(Cards.FIVE);
                case "6" -> cardHand.add(Cards.SIX);
                case "7" -> cardHand.add(Cards.SEVEN);
                case "8" -> cardHand.add(Cards.EIGHT);
                case "9" -> cardHand.add(Cards.NINE);
                case "10" -> cardHand.add(Cards.TEN);
                case "J" -> cardHand.add(Cards.JACK);
                case "Q" -> cardHand.add(Cards.QUEEN);
                case "K" -> cardHand.add(Cards.KING);
                default -> throw new IllegalStateException("Unexpected card string value: " + card);
            }
        }
        Hand playerHand = new Hand(cardHand);
        System.out.println("Your hand: " + playerHand.getCards().toString().replace("[", "").replace("]", ""));
        Cards dealerCard;
        switch (dealerCardString) {
            case "A" -> dealerCard = Cards.ACE;
            case "2" -> dealerCard = Cards.TWO;
            case "3" -> dealerCard = Cards.THREE;
            case "4" -> dealerCard = Cards.FOUR;
            case "5" -> dealerCard = Cards.FIVE;
            case "6" -> dealerCard = Cards.SIX;
            case "7" -> dealerCard = Cards.SEVEN;
            case "8" -> dealerCard = Cards.EIGHT;
            case "9" -> dealerCard = Cards.NINE;
            case "10" -> dealerCard = Cards.TEN;
            case "J" -> dealerCard = Cards.JACK;
            case "Q" -> dealerCard = Cards.QUEEN;
            case "K" -> dealerCard = Cards.KING;
            default -> throw new IllegalStateException("Unexpected dealer card string value: " + dealerCardString);
        }
        System.out.println("Dealer's up card: " + dealerCard);
        System.out.println("Calculating...");
        Calculator calculator = new Calculator();
        Actions actions = calculator.calculate(dealerCard, playerHand);
        System.out.println("Your action: " + actions.toString());
    }
}