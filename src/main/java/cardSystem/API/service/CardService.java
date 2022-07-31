package cardSystem.API.service;

import java.util.List;

import cardSystem.API.model.Card;

public interface CardService {
  public Card createCard(Card card);

  public Card getCard(long id);

  public List<Card> getAllCards();

  public Card updateCard(Card card, long id);

  public void deleteCard(long id);
}