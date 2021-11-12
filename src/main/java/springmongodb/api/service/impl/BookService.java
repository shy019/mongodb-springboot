package springmongodb.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springmongodb.api.model.Book;
import springmongodb.api.repository.IBookRepository;
import springmongodb.api.service.IBookService;

@Service
public class BookService implements IBookService {

	@Qualifier("BookRepository")
	IBookRepository iBookRepository;

	public BookService(IBookRepository iBookRepository) {
		this.iBookRepository = iBookRepository;
	}

	@Override
	public Book guardarLibro(Book book) {
		return iBookRepository.save(book);
	}

	@Override
	public List<Book> listarLibros() {
		return iBookRepository.findAll();
	}

	@Override
	public Optional<Book> listarLibrosPorId(int id) {
		return iBookRepository.findById(id);
	}

	@Override
	public boolean eliminarLibro(int id) throws Exception {
		try {
			if (!iBookRepository.findById(id).isEmpty()) {
				iBookRepository.deleteById(id);
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
