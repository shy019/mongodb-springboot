package springmongodb.api.service;

import java.util.List;
import java.util.Optional;

import springmongodb.api.model.Book;

public interface IBookService {

	public Book guardarLibro(Book book);

	public List<Book> listarLibros();

	public Optional<Book> listarLibrosPorId(int id);

	public boolean eliminarLibro(int id) throws Exception;

	//public Optional<Book> actualizarLibro(int id);
}
