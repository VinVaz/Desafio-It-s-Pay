package cardSystem.API.service;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

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

  private YearMonth parseDataValidade(String dataValidade) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Card.DATA_VALIDADE_FORMATO);
    return YearMonth.parse(dataValidade, formatter);
  }

  public Card create(JSONObject jsonCard) {
    String numero = (String) jsonCard.get("numero");
    String nomeUsuario = (String) jsonCard.get("nomeUsuario");
    String codigoSeguranca = (String) jsonCard.get("codigoSeguranca");
    String dataValidade = (String) jsonCard.get("dataValidade");

    Card card = new Card(numero, nomeUsuario, codigoSeguranca, parseDataValidade(dataValidade));
    return card;
  }

  public Card update(Card card, JSONObject jsonCard) {
    String numero = (String) jsonCard.get("id");
    String nomeUsuario = (String) jsonCard.get("nomeUsuario");
    String codigoSeguranca = (String) jsonCard.get("codigoSeguranca");
    String dataValidade = (String) jsonCard.get("dataValidade");

    card.setNumero(numero != null ? numero : card.getNumero());
    card.setNomeUsuario(nomeUsuario != null ? nomeUsuario : card.getNomeUsuario());
    card.setCodigoSeguranca(codigoSeguranca != null ? codigoSeguranca : card.getCodigoSeguranca());
    card.setDataValidade(dataValidade != null ? parseDataValidade(dataValidade) : card.getDataValidade());
    return card;
  }

}