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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cardSystem.API.model.Card;
import cardSystem.API.service.CardService;

@RestController
public class CardController {
	private static final Logger logger = LoggerFactory.getLogger(CardController.class);

	@Autowired
	private CardService cardService;

	@PostMapping("/cartoes")
	public ResponseEntity<Card> saveCard(@RequestBody Card card) {

		try {
			Card _card = cardService.createCard(card);
			return new ResponseEntity<>(_card, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cartoes/{id}")
	@CrossOrigin
	public ResponseEntity<Card> getCard(@PathVariable("id") Long id) {
		try {
			Card _card = cardService.getCard(id);
			return new ResponseEntity<>(_card, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/cartoes")
	public ResponseEntity<Object> getAllCards() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Card> cards = cardService.getAllCards();
			map.put("cartao", cards);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/cartoes/{id}")
	public ResponseEntity<Object> updateCard(@RequestBody Card card, @PathVariable("id") Long id) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Produto alterado com sucesso!");
		map.put("status", HttpStatus.NO_CONTENT.value());

		try {
			cardService.updateCard(card, id);
			return new ResponseEntity<>(map, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/cartoes/{id}")
	public ResponseEntity<Object> deleteCard(@PathVariable("id") Long id) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menssagem", "Produto deletado com sucesso!");
		map.put("status", HttpStatus.NO_CONTENT.value());
		Map<String, Object> outerMap = new HashMap<String, Object>();
		outerMap.put("response", map);

		try {
			cardService.deleteCard(id);
			return new ResponseEntity<>(outerMap, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
