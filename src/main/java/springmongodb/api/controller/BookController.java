package springmongodb.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springmongodb.api.model.Book;
import springmongodb.api.service.IBookService;

@RestController
@RequestMapping("mintic/api")
public class BookController {

	@Qualifier("BookService")
	IBookService iBookService;

	public BookController(IBookService iBookService) {
		this.iBookService = iBookService;
	}

	/**
	 * Guardar Libro
	 * 
	 * @param book
	 * @return ResponseEntity<Book>
	 */
	@RequestMapping(value = "/books/save", method = RequestMethod.POST, consumes = { "application/JSON" }, produces = {
			"application/JSON" })
	public ResponseEntity<Book> saveBook(@RequestBody @Valid Book book) {
		try {
			return new ResponseEntity<Book>(iBookService.guardarLibro(book), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Listar libros
	 * 
	 * @param book
	 * @return ResponseEntity<List<Book>>
	 */
	@RequestMapping(value = "/books", produces = { "application/JSON" })
	public ResponseEntity<List<Book>> getBooks() {
		try {
			return new ResponseEntity<List<Book>>(
					iBookService.listarLibros().isEmpty() ? null : iBookService.listarLibros(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Listar libros por id
	 * 
	 * @param book
	 * @return ResponseEntity<List<Book>>
	 */
	@RequestMapping(value = "/books/{id}", produces = { "application/JSON" })
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		try {
			return new ResponseEntity<Book>(
					iBookService.listarLibrosPorId(id).isEmpty() ? null : iBookService.listarLibrosPorId(id).get(),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Eliminar libro por id
	 * 
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE, produces = { "application/JSON" })
	public ResponseEntity<String> deleteBookById(@PathVariable int id) {
		try {
			return new ResponseEntity<String>(
					iBookService.eliminarLibro(id) ? "Registro eliminado con exito" : "No existe un libro con id " + id,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Actualizar libro por id
	 * 
	 * @param id
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/books/update", method = RequestMethod.POST, consumes = {
			"application/JSON" }, produces = { "application/JSON" })
	public ResponseEntity<Book> updateBookById(@RequestBody @Valid Book book) {
		try {
			return new ResponseEntity<Book>(iBookService.guardarLibro(book), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
