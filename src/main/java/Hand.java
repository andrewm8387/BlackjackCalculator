import java.util.ArrayList;

public class Hand {

    private final ArrayList<Cards> cards = new ArrayList<Cards>();

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
        return new ArrayList<Cards>(cards);
    }
}
