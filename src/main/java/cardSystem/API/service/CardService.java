package cardSystem.API.service;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import cardSystem.API.model.Card;

@Service
public class CardService {
  private List<Card> cards;

  public void createCardList() {
    if (cards == null) {
      cards = new ArrayList<>();
    }
  }

  public boolean isJSONValid(String jsonString) {
    try {
      return new ObjectMapper().readTree(jsonString) != null;
    } catch (IOException e) {
      return false;
    }
  }

  private long parseId(JSONObject card) {
    return Long.valueOf((int) card.get("id"));
  }

  public Card create(JSONObject jsonCard) {
    String numero = (String) jsonCard.get("numero");
    String nomeUsuario = (String) jsonCard.get("nomeUsuario");
    String codigoSeguranca = (String) jsonCard.get("codigoSeguranca");
    String dataValidade = (String) jsonCard.get("dataValidade");

    Card card = new Card();
    return card;
  }
}