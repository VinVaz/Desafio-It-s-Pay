package cardSystem.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cardSystem.API.model.Card;
import cardSystem.API.service.CardService;

@RestController
@RequestMapping(value = "/cartoes")
public class CardController {
	private static final Logger logger = LoggerFactory.getLogger(CardController.class);

	@Autowired
	private CardService cardService;

	@PostMapping
	public ResponseEntity<Card> saveCard(@RequestBody Card card) {
		System.out.println(card);
		try {
			Card _card = cardService.createCard(card);
			return new ResponseEntity<>(_card, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<Card> getCard(@PathVariable("id") Long id) {
		System.out.println(id);
		try {
			Card _card = cardService.getCard(id);
			return new ResponseEntity<>(_card, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<Card>> getAllCards() {
		System.out.println("worked");
		try {
			List<Card> cards = cardService.getAllCards();
			return new ResponseEntity<>(cards, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCard(@RequestBody Card card, @PathVariable("id") Long id) {
		System.out.println(card);
		try {
			cardService.updateCard(card, id);
			return new ResponseEntity<>("Produto alterado com sucesso!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCard(@PathVariable("id") Long id) {
		System.out.println(id);
		try {
			cardService.deleteCard(id);
			return new ResponseEntity<>("Produto deletado com sucesso!", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
