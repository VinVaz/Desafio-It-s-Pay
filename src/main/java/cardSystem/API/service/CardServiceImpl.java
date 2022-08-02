package cardSystem.API.service;

import java.util.List;
import java.util.Optional;

import javax.print.event.PrintEvent;
import static java.lang.System.out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cardSystem.API.model.Card;
import cardSystem.API.repository.CardRepository;
import cardSystem.API.exception.CardNotExistsException;
import cardSystem.API.service.CardService;

@Service
public class CardServiceImpl implements CardService {
  @Autowired
  private CardRepository cardRepository;

  @Override
  public Card createCard(Card card) {
    Card newCard = cardRepository
        .save(new Card(card.getNumero(), card.getNomeUsuario(), card.getCodigoSeguranca(),
            card.getDataValidade()));
    return newCard;
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

    Card _card = getCard(id);

    _card.setNumero(card.getNumero());
    _card.setNomeUsuario(card.getNomeUsuario());
    _card.setCodigoSeguranca(card.getCodigoSeguranca());
    _card.setDataValidade(card.getDataValidade());

    return cardRepository.save(_card);
  }

  @Override
  public void deleteCard(long id) {
    Card cardData = getCard(id);
    cardRepository.deleteById(cardData.getId());
  }
}