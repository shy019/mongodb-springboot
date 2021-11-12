package springmongodb.api.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import springmongodb.api.model.Book;

public interface IBookRepository extends MongoRepository<Book, Integer>{

}
