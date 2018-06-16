package ave.bertrand.rest.controller;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ave.bertrand.model.Book;
import ave.bertrand.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private final Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	/**
	 * Find by id Book (for simple key).
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<Book> findById(@PathVariable String id) {
		log.info("Find by id Books : {}.", id);

		Book fullyLoadedStore = bookService.findOne(id);

		return Optional.ofNullable(fullyLoadedStore).map(store -> new ResponseEntity<>(store, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * Add some books.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public ResponseEntity<Book> add() {

		Book book = new Book("1101", "Elasticsearch Basics 2", "Rambabu rosa", new Date());
		Book savedBook = bookService.save(book);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
