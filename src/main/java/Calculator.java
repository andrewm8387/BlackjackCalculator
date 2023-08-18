public class Calculator {

    public Actions calculate(Cards dealerCard, Hand playerCards) { // assuming double after split is allowed

        if (playerCards.size() == 2) { //first deal
            if (playerCards.get(0).equals(playerCards.get(1))) {
                switch (playerCards.get(0)) {
                    case ACE, EIGHT -> {
                        return Actions.SPLIT;
                    }
                    case TWO, THREE, SEVEN -> {
                        if (dealerCard.value() < 8) {
                            return Actions.SPLIT;
                        }
                    }
                    case FOUR -> {
                        if (dealerCard.value() < 7 && dealerCard.value() > 4) {
                            return Actions.SPLIT;
                        }
                    }
                    case SIX -> {
                        if (dealerCard.value() < 7) {
                            return Actions.SPLIT;
                        }
                    }
                    case NINE -> {
                        if (dealerCard.value() < 10 && dealerCard.value() != 7) {
                            return Actions.SPLIT;
                        }
                    }
                    case FIVE, TEN, JACK, QUEEN, KING -> {
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + playerCards.get(0) + ", " + playerCards.get(1));
                }
            }
            if (playerCards.get(0).equals(Cards.ACE) || playerCards.get(1).equals(Cards.ACE)) { //soft hand
                switch (playerCards.get((playerCards.get(0).equals(Cards.ACE) ? 1 : 0))) {
                    case TWO, THREE -> {
                        if (dealerCard.value() < 5 || dealerCard.value() > 6) {
                            return Actions.HIT;
                        } else {
                            return Actions.DOUBLE;
                        }
                    }
                    case FOUR, FIVE -> {
                        if (dealerCard.value() < 4 || dealerCard.value() > 6) {
                            return Actions.HIT;
                        } else {
                            return Actions.DOUBLE;
                        }
                    }
                    case SIX -> {
                        if (dealerCard.value() < 3 || dealerCard.value() > 6) {
                            return Actions.HIT;
                        } else {
                            return Actions.DOUBLE;
                        }
                    }
                    case SEVEN -> {
                        if (dealerCard.value() < 7) {
                            return Actions.DOUBLE;
                        } else if (dealerCard.value() > 8) {
                            return Actions.HIT;
                        } else {
                            return Actions.STAND;
                        }
                    }
                    case EIGHT -> {
                        if (dealerCard.value() == 7) {
                            return Actions.DOUBLE;
                        } else {
                            return Actions.STAND;
                        }
                    }
                    case NINE, TEN, JACK, QUEEN, KING -> {
                        return Actions.STAND;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + playerCards.get(0) + ", " + playerCards.get(1));
                }
            }
        }
        //hard hand
        int total = 0;
        for (Cards card : playerCards.getCards()) { //add up total
            total += card.value();
        }
        if (total == 21) {
            return Actions.STAND;
        }
        if (total > 21) {
            for (int i = 0; i < playerCards.count(Cards.ACE); i++) {
                total -= 10;
                if (total <= 21) {
                    break;
                }
            }
            if (total > 21) {
                throw new IllegalStateException("Unexpected total value: " + total);
            }
        }
        switch (total) {
            case 2, 3, 4, 5, 6, 7, 8 -> {
                return Actions.HIT;
            }
            case 9 -> {
                if (dealerCard.value() < 3 || dealerCard.value() > 6) {
                    return Actions.HIT;
                } else {
                    return Actions.DOUBLE;
                }
            }
            case 10 -> {
                if (dealerCard.value() < 10) {
                    return Actions.DOUBLE;
                } else {
                    return Actions.HIT;
                }
            }
            case 11 -> {
                return Actions.DOUBLE;
            }
            case 12 -> {
                if (dealerCard.value() < 4 || dealerCard.value() > 6) {
                    return Actions.HIT;
                } else {
                    return Actions.STAND;
                }
            }
            case 13, 14, 15, 16 -> {
                if (dealerCard.value() < 7) {
                    return Actions.STAND;
                } else {
                    return Actions.HIT;
                }
            }
            case 17, 18, 19, 20, 21 -> {
                return Actions.STAND;
            }
            default -> throw new IllegalStateException("Unexpected total value: " + total);
        }

    }
}
