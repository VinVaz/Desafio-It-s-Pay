package cardSystem.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cardSystem.API.model.Card;
import cardSystem.API.service.CardService;

@RestController
public class CardController {

	@Autowired
	private CardService cardService;

	@RequestMapping(value = "/cartoes", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public ResponseEntity<Card> saveCard(@RequestBody Card card) {

		cardService.createCard(card);
		return new ResponseEntity<>(card, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/cartoes/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<Card> getCard(@PathVariable("id") Integer id) {

		return new ResponseEntity<>(cardService.getCard(id), HttpStatus.FOUND);
	}

	@RequestMapping(value = "/cartoes", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<List<Card>> getAllCards() {

		return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
	}

	@RequestMapping(value = "/cartoes/{id}", consumes = "application/json", produces = "application/json", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateCard(@RequestBody Card card, @PathVariable("id") Long id) {

		return new ResponseEntity<Object>("Produto alterado com sucesso!", HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/cartoes/{id}", consumes = "text/plain", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCard(@PathVariable("id") Integer id) {

		cardService.deleteCard(id);

		return new ResponseEntity<Object>("Produto deletado com sucesso!", HttpStatus.NO_CONTENT);
	}

}
