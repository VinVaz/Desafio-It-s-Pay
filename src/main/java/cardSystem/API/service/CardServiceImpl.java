package cardSystem.API.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import cardSystem.API.model.Card;
import cardSystem.API.repository.CardRepository;
import cardSystem.API.exception.CardNotExistsException;

@Service
public class CardServiceImpl {
  @Autowired
  private CardRepository cardRepository;

  @Override
  public Card createCard(Card card) {

    return cardRepository.save(card);

  }

  @Override
  public Card getCard(long id) {

    Optional<Card> card = cardRepository.findById(id);
    if (!card.isPresent()) {
      throw new CardNotExistsException("Cartão de ID " + id + "não existe no sistema");
    }
    return card.get();
  }

  @Override
  public List<Card> getAllCards() {

    List<Card> listCard = cardRepository.findAll();

    if (listCard.isEmpty()) {
      throw new CardNotExistsException("Nenhum cartão salvo no sistema");
    }

    return listCard;
  }

  @Override
  public Card updateCard(Card card, long id) {

    Optional<Card> storedCard = cardRepository.findById(id);
    if (!storedCard.isPresent()) {
      throw new CardNotExistsException("Cartão de ID " + id + "não existe no sistema");
    }

    Card newCard = storedCard.get();
    newCard.setNumero(card.getNumero());
    newCard.setNomeUsuario(card.getNomeUsuario());
    newCard.setCodigoSeguranca(card.getCodigoSeguranca());
    newCard.setDataValidade(card.getDataValidade());

    return cardRepository.save(newCard);
  }

  @Override
  public void deleteCard(long id) {

    if (getCard(id) != null) {
      throw new CardNotExistsException("Employee with ID " + id + " does not exists");
    }

    cardRepository.deleteById(id);

  }

}