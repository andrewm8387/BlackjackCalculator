import java.util.ArrayList;

public class Hand {

    private final ArrayList<Cards> cards = new ArrayList<>();

    public Hand(ArrayList<Cards> cards) {
        this.cards.addAll(cards);
    }

    public Cards get(int index) {
        return cards.get(index);
    }

    public int size() {
        return cards.size();
    }

    public ArrayList<Cards> getCards() {
        return new ArrayList<>(cards);
    }

    public int count(Cards c) {
        int count = 0;
        for (Cards card : cards) {
            if (card.equals(c)) {
                count++;
            }
        }
        return count;
    }
}
